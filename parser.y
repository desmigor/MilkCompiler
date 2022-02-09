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

// Literals
%token <string> TRUE FALSE
%token <string> TOKEN_INT_LITERAL TOKEN_REAL_LITERAL TOKEN_STRING_LITERAL

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
%token ASSIGN // ":="
%token LT // "<"
%token GT // ">"
%token LTEQ // "<="
%token GTEQ // ">="
%token EQ // "="
%token NOT_EQ // "/="
%token PLUS // "+"
%token MINUS // "-"
%token MULT // "*"
%token DIV // "/"
%token INCR // "+="

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
Program:
  %empty          { ast = new ElementsList(); lines = new ArrayList<Integer>(); }
| Program (element) Declaration { ast.add($2); lines.add(@2.begin.line); }
;

Declaration:
  'var' VariableDefinition   { $$ = $1; }
| literal     { $$ = $1; }
| list        { $$ = $1; }
|
| "'" element { $$ = new Quote($2); }
;

VariableDefinition:
  literal {$$ = $1;}
| ',' VariableDefintion {$$ = $2;}
;

assignmnet:
  literal ':=' exp
literal:
  INT { $$ = $1; }
| REAL    { $$ = $1; }
| BOOLEAN { $$ = $1; }
| STRING  { $$ = $1; }
| ARRAY { $$ = $1; }
| TUPLE { $$ = $1; }
;

list:
  "(" list_elements ")" { $$ = $2; }
| "(" special_form ")"  { $$ = $2; }
;

list_elements:
  %empty                { $$ = new ElementsList(); }
| list_elements element { $$ = $1; $1.add($2); }
;

special_form:
  QUOTE element                         { $$ = new Quote($2); }
| FUNC identifier list_of_atoms element { $$ = new Func($2, $3, $4, @1.begin.line); }
| LAMBDA list_of_atoms element          { $$ = new Lambda($2, $3, @1.begin.line); }
| PROG list_of_atoms element            { $$ = new Prog($2, $3); }
| COND element element                  { $$ = new Cond($2, $3); }
| COND element element element          { $$ = new Cond($2, $3, $4); }
| WHILE element element                 { $$ = new While($2, $3); }
| RETURN element                        { $$ = new Return($2); }
| BREAK                                 { $$ = new Break(); }
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
