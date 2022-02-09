%require "3.0"
%language "Java"
%define api.pure full
%define parse.lac full
%define parse.error verbose

%define api.package parser
%define api.parser.class {Parser}
%define api.value.type {Object}
%define api.parser.public
%define api.push-pull push
%define parse.error custom
%define parse.trace
%locations

%code imports {
import java.io.IOException;
import java.util.*;
import lexems.*;
}

%code {
    private static ElementsList ast;
    public static List<Integer> lines;
    public static ElementsList makeAST() throws IOException {
        MyLexer l = new MyLexer(System.in);
        Parser p = new parser.Parser(l);
        int status;
        do {
            int token = l.getToken();
            IElement lval = l.getValue();
            Parser.Location yyloc = l.getLocation();
            status = p.push_parse(token, lval, yyloc);
        } while (status == Parser.YYPUSH_MORE);
        if (status != Parser.YYACCEPT) {
            return null;
        }
        return ast;
    }
}

%union {
  
  NProgram program;
  NInstruction instruction;
  NBlock block;
  NDeclaration declaration;
  NArray array;
  NTuple tuple;
  NStatement statement;
  NAssignment assignment;
  NPrint print;
  NFunctionDefinition funcdef;
  NParameters param;
  NIf ifstmt;
  NIfElse ifelse;
  NLoop loop;
  NReturn returnstmt;

  NExpression expression;
  NIdentifier identifier;
  NIntegerLiteral integer_lit;
  NReal real;
  NBool boolstmt;
  NStringLiteral string_lit;
  NBinaryOperator binaryop;
  NTypeCheck typecheck;
  NUnary unary;
  NReadInput readinput;
  vector<NDeclaration> variableVector;
  vector<NStatement> statementVector;
  vector<NExpression> expressionVector;
  vector<NIdentifier> paramVector;

  string string;
  int token;
}

// other
%token <token> FUNCTOR EOF UNKNOWN

// Identifier
%token <string> IDENTIFIER

// Literals
%token <string> TRUE FALSE
%token <string> INT_LITERAL REAL_LITERAL STRING_LITERAL

// Types
%token <string> INT
%token <string> REAL
%token <string> BOOLE
%token <string> STRING
%token <string> EMPTY
%token <string> ARRAY
%token <string> TUPLE

// Delimeters
%token <token> RPAREN // ")"
%token <token> LPAREN // "("
%token <token> LBRACK // "["
%token <token> RBRACK // "]"
%token <token> LBRACE // "{"
%token <token> RBRACE // "}"
%token <token> SEMICOLON // ";"
%token <token> DOT // "."
%token <token> COMMA // ","

// Keywords
%token <token> OR 
%token <token> AND
%token <token> XOR
%token <token> NOT
%token <token> IS
%token <token> IN 
%token <token> FOR
%token <token> WHILE
%token <token> PRINT
%token <token> RETURN
%token <token> IF 
%token <token> THEN 
%token <token> ELSE
%token <token> END
%token <token> LOOP
%token <token> VAR


// Operators
%token <token> ASSIGN // ":="
%token <token> LT // "<"
%token <token> GT // ">"
%token <token> LTEQ // "<="
%token <token> GTEQ // ">="
%token <token> EQ // "="
%token <token> NOT_EQ // "/="
%token <token> PLUS // "+"
%token <token> MINUS // "-"
%token <token> MULT // "*"
%token <token> DIV // "/"
%token <token> INCR // "+="

// Input
%token <string> READINT READREAL READSTRING

// %type
%type <block> Body LoopBody Program
%type <declaration> Declaration 
%type <statement> Statement 
%type <expression> Expression Relation Factor Term Unary Primary Literal 
%type <funcdef> FunctionLiteral
%type <expression> ArrayLiteral TupleLiteral
%type <statement> Assignment Return If Loop
%type <print> Print Expressions 
%type <param> Identifiers Parameters
%type <string> TypeIndicator
%start Program


%%
Program : Body                                      { programBlock = $1; }
        ;                                   
Body :                                              { $$ = new NBlock(); }
      | Declaration Body                            { $$ = $2; $$->push_back($1); }
      | Statement Body                              { $$ = $2; $$->push_back($1); }
      | Expression Body                             { $$ = $2; $$->push_back($1); }
      ;
Declaration : VAR IDENTIFIER SEMI                                       { $$ = new NDeclaration($2); }                                //{printf("He");} 
            | VAR IDENTIFIER ASSIGNMENT Expression SEMI           { $$ = new NDeclaration($2, $4); }
            ;
Expression : Relation                                     { $$ = $1; }
           | Relation AND Relation                  { $$ = new NBinaryOperator($1, $2, $3); }
           | Relation OR Relation                   { $$ = new NBinaryOperator($1, $2, $3); }
           | Relation XOR Relation                  { $$ = new NBinaryOperator($1, $2, $3); }
           ;
Expressions : Expression                                      { $$ = new NPrint(); $$->push_back($1); }
            | Expression COMMA Expressions              { $$ = $3; $$->push_back($1); }
            ;
Relation : Factor                                         { $$ = $1; }
         | Factor LESS Factor                       { $$ = new NBinaryOperator($1, $2, $3); }
         | Factor LEQ Factor                        { $$ = new NBinaryOperator($1, $2, $3); }
         | Factor GREAT Factor                      { $$ = new NBinaryOperator($1, $2, $3); }
         | Factor GEQ Factor                        { $$ = new NBinaryOperator($1, $2, $3); }
         | Factor EQUAL Factor                      { $$ = new NBinaryOperator($1, $2, $3); }
         | Factor NEQ Factor                        { $$ = new NBinaryOperator($1, $2, $3); }
         ;
Factor : Term                                             { $$ = $1; }
       | Term PLUS Factor                           { $$ = new NBinaryOperator($1, $2, $3); }
       | Term MINUS Factor                          { $$ = new NBinaryOperator($1, $2, $3); }
       ;
Term : Unary                                              { $$ = $1; }
     | Unary MULT Term                              { $$ = new NBinaryOperator($1, $2, $3); }
     | Unary DIV Term                               { $$ = new NBinaryOperator($1, $2, $3); }
     ;
Unary : Primary                                 { $$ = $1; }
      | PLUS Primary                      { $$ = new NUnary($1, $2); }
      | MINUS Primary                     { $$ = new NUnary($1, $2); }
      | NOT Primary                       { $$ = new NUnary($1, $2); }
      | Literal                                 { $$ = $1; }
      | LPAREN Expression RPAREN    { $$ = $2; }
      | PLUS Primary IS TypeIndicator           { $$ = new NTypeCheck($1, $2, $4); }
      | MINUS Primary IS TypeIndicator          { $$ = new NTypeCheck($1, $2, $4); }
      | NOT Primary IS TypeIndicator            { $$ = new NTypeCheck($1, $2, $4); }
      | Primary IS TypeIndicator                      { $$ = new NTypeCheck($1, $3); }
      ;
Primary : IDENTIFIER Tail                             { $$ = new NIdentifier($1); }
        | READINT                                     { $$ = new NReadInput(); }
        | READREAL                                    { $$ = new NReadInput(); }
        | READSTRING                                  { $$ = new NReadInput(); }
        ;
Tail : /* empty */
     | DOT INT_LITERAL                   
     | DOT IDENTIFIER              
     | LBRACK Expression RBRACK   
     | LPAREN Expressions RPAREN    
     ;
Statement : Assignment                                  { $$ = $1; }
          | Print                                       { $$ = $1; }
          | Return                                      { $$ = $1; }
          | If                                          { $$ = $1; }
          | Loop                                        { $$ = $1; }
          ;
Assignment : Primary ASSIGNMENT Expression SEMI   { $$ = new NAssignment($1, $3); }   
           ;
Print : PRINT Expressions SEMI                    { $$ = $2; }         
      ;

Return : RETURN Expression SEMI                   { $$ = new NReturn($2); }             
       | RETURN SEMI                                 { $$ = new NReturn(); }  
       ;
If : IF Expression THEN Body END            { $$ = new NIf($2, $4); }
   | IF Expression THEN Body ELSE Body END      { $$ = new NIfElse($2, $4, $6); }
   ;
Loop : WHILE Expression LoopBody                        { $$ = new NLoop($2, $3); }
     | FOR IDENTIFIER IN TypeIndicator LoopBody             { $$ = NULL; }
     ;
LoopBody : LOOP Body END                          { $$ = $2; }
         ;
TypeIndicator : INT                                     { $$ = $1; }                   
              | REAL                                    { $$ = $1; }
              | BOOL                                    { $$ = $1; }
              | STRING                                  { $$ = $1; }
              | EMPTY                                   { $$ = $1; }
              | ARRAY                                   { $$ = $1; }
              | TUPLE                                   { $$ = $1; }
              ;
Literal : INT_LITERAL                                   { $$ = new NIntegerLiteral(atol($1->c_str())); }
        | REAL_LITERAL                                  { $$ = new NReal(atof($1->c_str())); }
        | TRUE                                          { $$ = new NBool($1); }
        | FALSE                                         { $$ = new NBool($1); }
        | STRING_LITERAL                                { $$ = new NStringLiteral($1); }
        | ArrayLiteral                                        { $$ = $1; }
        | TupleLiteral                                        { $$ = $1; }
        | FunctionLiteral                                     { $$ = $1; }
        ;
ArrayLiteral : LBRACK RBRACK                    { $$ = new NArray(); }
             | LBRACK Expressions RBRACK        { $$ = new NArray(); }
             ;
TupleLiteral : LCURLY RCURLY                      { $$ = new NTuple(); } 
             | LCURLY IDENTIFIER TupleTail        { $$ = new NTuple(); }
             | LCURLY IDENTIFIER ASSIGNMENT Expression TupleTail      { $$ = new NTuple(); }
             ;
TupleTail : RCURLY
          | COMMA IDENTIFIER TupleTail
          | COMMA IDENTIFIER ASSIGNMENT Expression TupleTail
          ;
FunctionLiteral : FUNC IS Body END                          { $$ = new NFunctionDefinition();  $$->setBody($3); }
                | FUNC FUNCTOR Expression                         { $$ = new NFunctionDefinition();  $$->setExpression($3); }
                | FUNC Parameters IS Body END               { $$ = new NFunctionDefinition(); $$->setParameters($2); $$->setBody($4); }
                | FUNC Parameters FUNCTOR Expression              { $$ = new NFunctionDefinition(); $$->setParameters($2); $$->setExpression($4); }
                ;
Parameters : LPAREN Identifiers RPAREN                            { $$ = $2; }
           ;
Identifiers : IDENTIFIER                                                { $$ = new NParameters(); $$->push_parameter(new NIdentifier($1)); }
            | IDENTIFIER COMMA Identifiers                        { $$ = $3; $$->push_parameter(new NIdentifier($1)); }
            ;


%%
private Yylex lexer;
private int yylex () {
    int yyl_return = -1;
    try {
        yylval = new ParserVal(0);
        yyl_return = lexer.yylex();
    }
    catch (IOException e) {
        System.err.println("IO error :"+e);
    }
    return yyl_return;
}


public void yyerror (String error) {
    System.err.println ("Error: " + error);
}


public Parser(Reader r) {
    lexer = new Yylex(r, this);
}


static boolean interactive;

public static void main(String args[]) throws IOException {
    System.out.println("BYACC/Java with JFlex Calculator Demo");

    Parser yyparser;
    if ( args.length > 0 ) {
        // parse a file
        yyparser = new Parser(new FileReader(args[0]));
    }
    else {
        // interactive mode
        System.out.println("[Quit with CTRL-D]");
        System.out.print("Expression: ");
        interactive = true;
        yyparser = new Parser(new InputStreamReader(System.in));
    }

    yyparser.yyparse();

    if (interactive) {
        System.out.println();
        System.out.println("Have a nice day");
    }
}
