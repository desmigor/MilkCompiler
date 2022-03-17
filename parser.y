%define api.prefix {parser}
%define api.parser.class {parser}
%define api.parser.public
%define parse.error verbose

%code imports{
  import java.io.InputStream;
  import java.io.InputStreamReader;
  import java.io.Reader;
  import java.io.IOException;
  import java.io.EOFException;
  import syntax_tree.*;
}


%code {

	Program root;

  public static void main(String args[]) throws IOException {
    ParserLexer lexer = new ParserLexer(System.in);
    parser p = new parser(lexer);
    if(p.parse()) {
      System.out.println("---------------------\n Parser Completed Successfully!");
	  System.out.println(p.root.toString());
	}
    return;
  }
}



//All keywords
%token KW_IF KW_IS KW_VAR KW_END KW_TRUE KW_FALSE KW_THEN
%token KW_ELSE KW_FOR KW_LOOP KW_IN KW_WHILE KW_FUNCT KW_RETURN KW_PRINT IDENTIFIER

//Boolean
%token BOOLEAN_LITERAL

// Separators
%token LPAREN RPAREN LBRACE RBRACE LBRACK RBRACK SEMICOLON COMMA DOT

// Operators
%token EQ ASSIGN GT LT LTEQ GTEQ PLUS MINUS MULT DIV EXPR TOKEN_OR TOKEN_AND TOKEN_XOR TOKEN_NOT

// Numeric
%token INTEGER_LITERAL REAL_LITERAL

//Other tokens
%token COMMENT STRING UNKNOWN_TOKEN TOKEN_EOF

/* A union of all the types that can be the result of parsing actions. */

/* Declare types for the grammar's non-terminals. */

%left IDENTIFIER

%left KW_RETURN KW_PRINT KW_IN

%left COMMA

%left PLUS MINUS
%left MULT DIV

%left GT LT GTEQ LTEQ

%left EQ

%left TOKEN_NOT
%left TOKEN_XOR
%left TOKEN_OR
%left TOKEN_AND
%left ASSIGN

%left LPAREN LBRACE LBRACK
%start Program

//Grammar Definition ___________
%%
Program : Prog { root = new Program($1); } ;

Prog :
    %empty { $$ = new Program(); }
    | Body Prog { $$ = new Program($2, $1); }

;

IDENTIFIER_T : IDENTIFIER { $$ = new Identifier($1); } ;

Body :
    Declaration SEMICOLON
	 | Assignment SEMICOLON
   | Expression SEMICOLON
	 | PrintStatement SEMICOLON
	 | Statement
	 | ReturnStatement
;

Declaration : KW_VAR IDENTIFIER_T   { $$ = new Declaration($2); }
    | KW_VAR IDENTIFIER_T ASSIGN Expression { $$ = new Declaration($2, $4); }
		| KW_VAR IDENTIFIER_T ASSIGN FunctionDef { $$ = new Declaration($2, $4, 0); }
;

ReturnStatement : KW_RETURN Expression { $$ = new ReturnStatement($2); } ;

PrintStatement : KW_PRINT Expression { $$ = new PrintStatement($2); } ;

Assignment : IDENTIFIER_T ASSIGN Expression { $$ = new Assignment($1, $3); } ;

Expression : IDENTIFIER_T
		 | LPAREN Expression RPAREN
		 | Relation
		 | Value
		 | FunctionCall
		 | Calc
		 | ArrayAccess
;

ArrayAccess : Expression LBRACK Expression RBRACK { $$ = new ArrayAccess($1, $3); } ;

Relation : Expression LT Expression { $$ = new BinaryRelation($1, $3, RelationOp.LT); }
         | Expression LTEQ Expression { $$ = new BinaryRelation($1, $3, RelationOp.LTEQ); }
         | Expression GT Expression   { $$ = new BinaryRelation($1, $3, RelationOp.GT); }
         | Expression GTEQ Expression  { $$ = new BinaryRelation($1, $3, RelationOp.GTEQ); }
         | Expression EQ Expression     { $$ = new BinaryRelation($1, $3, RelationOp.EQ); }
		 | Expression TOKEN_AND Expression { $$ = new BinaryRelation($1, $3, RelationOp.AND); }
		 | Expression TOKEN_OR Expression { $$ = new BinaryRelation($1, $3, RelationOp.OR); }
		 | Expression TOKEN_XOR Expression { $$ = new BinaryRelation($1, $3, RelationOp.XOR); }
		 | TOKEN_NOT Expression { $$ = new UnaryRelation($2, RelationOp.NOT); }
;

Calc :  Expression PLUS Expression { $$ = new CalcExpression($1, $3, CalcOp.PLUS); }
		 | Expression MINUS Expression { $$ = new CalcExpression($1, $3, CalcOp.MINUS); }
		 | Expression MULT Expression { $$ = new CalcExpression($1, $3, CalcOp.MULT); }
		 | Expression DIV Expression { $$ = new CalcExpression($1, $3, CalcOp.DIV); }
;

Value : STRING { $$ = new StringValue($1); }
		 | INTEGER_LITERAL { $$ = new IntegerValue($1); }
		 | REAL_LITERAL { $$ = new RealValue($1); }
		 | BOOLEAN_LITERAL { $$ = new BooleanValue($1); }
		 | ArrayValue
		 | DictValue
;

ArrayValue : LBRACK ArrayValues RBRACK { $$ = new ArrayValue($2); } ;

DictValue : LBRACE DictValues RBRACE { $$ = new DictValue($2); } ;

DictValues : %empty { $$ = new DictValues(); }
		 | Assignment COMMA DictValues { $$ = new DictValues($3, $1); }
;

ArrayValues : %empty { $$ = new ArrayValues(); }
		 | Expression COMMA ArrayValues { $$ = new ArrayValues($3, $1); }
;

FunctionDef : KW_FUNCT LPAREN Params RPAREN KW_IS Prog KW_END { $$ = new FunctionDef($3, $6); } ;

FunctionCall : IDENTIFIER_T LPAREN Args RPAREN { $$ = new FunctionCall($1, $3); } ;

Params: %empty { $$ = new Params(); }
	     | IDENTIFIER_T COMMA Params { $$ = new Params($3, $1); }
;

Args: %empty { $$ = new Args(); }
		 | Expression COMMA Args { $$ = new Args($3, $1); }
;

Statement : IfStatement
		 | ForStatement
		 | WhileStatement
;

IfStatement : KW_IF LPAREN Expression RPAREN KW_THEN Prog KW_END { $$ = new IfStatement($3, $6); }
		 | KW_IF LPAREN Expression RPAREN KW_THEN Prog KW_ELSE Prog KW_END { $$ = new IfStatement($3, $6, $8); }
;

ForStatement : KW_FOR LPAREN IDENTIFIER_T KW_IN Expression RPAREN KW_LOOP Prog KW_END { $$ = new ForStatement($3, $5, $8); } ;

WhileStatement : KW_WHILE LPAREN Expression RPAREN KW_LOOP Prog KW_END { $$ = new WhileStatement($3, $6); } ;

%%

class ParserLexer implements parser.Lexer {
  InputStreamReader it;
  Yylex yylex;

  public ParserLexer(InputStream is){
    it = new InputStreamReader(is);
    yylex = new Yylex(it);
  }

  @Override
  public void yyerror (String s){
	System.out.println("---------------------\nParser Completed with some errors");
    System.err.println("\t-> Error: " + s);
  }

  @Override
  public Object getLVal() {
    return yylex.yytext();
  }

  @Override
  public int yylex () throws IOException{	
	int token = yylex.yylex();
    return token;
  }
}


// not take it
