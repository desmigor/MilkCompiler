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
}


%code {
  public static void main(String args[]) throws IOException {
    ParserLexer lexer = new ParserLexer(System.in);
    parser p = new parser(lexer);
    if(p.parse())
      System.out.println("---------------------\n Parser Completed Successfully!");
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

%left KW_RETURN KW_PRINT

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
%start Prog

//Grammar Definition ___________
%%  
Prog : Body
;

Body : 
     | Declaration SEMICOLON Body
	 | Assignment SEMICOLON Body
     | Expression SEMICOLON Body
	 | PrintStatement SEMICOLON Body
	 | Statement Body
	 | ReturnStatement
;

Declaration : KW_VAR IDENTIFIER                                 
         | KW_VAR IDENTIFIER ASSIGN Expression
		 | KW_VAR IDENTIFIER ASSIGN FunctionDef
;

ReturnStatement : KW_RETURN Expression ;

PrintStatement : KW_PRINT Expression;

Assignment : IDENTIFIER ASSIGN Expression ;

Expression : IDENTIFIER
		 | LPAREN Expression RPAREN
		 | Relation
		 | Value
		 | FunctionCall
		 | Calc
		 | ArrayAccess
;

ArrayAccess : Expression LBRACK Expression RBRACK ;

Relation : Expression LT Expression                    
         | Expression LTEQ Expression                  
         | Expression GT Expression                    
         | Expression GTEQ Expression                  
         | Expression EQ Expression                    
		 | Expression TOKEN_AND Expression
		 | Expression TOKEN_OR Expression
		 | Expression TOKEN_XOR Expression
		 | TOKEN_NOT Expression
;

Calc :  Expression PLUS Expression 
		 | Expression MINUS Expression
		 | Expression MULT Expression 
		 | Expression DIV Expression 
;

Value : STRING
		 | INTEGER_LITERAL
		 | REAL_LITERAL
		 | KW_TRUE
		 | KW_FALSE
		 | ArrayValue
		 | DictValue
;

ArrayValue : LBRACK ArrayValues RBRACK ;

DictValue : LBRACE DictValues RBRACE ;

DictValues : //empty
		 | Assignment COMMA DictValues
;		 

ArrayValues : //empty
		 | Expression COMMA ArrayValues
;
		 
FunctionDef : KW_FUNCT LPAREN Params RPAREN KW_IS Body KW_END ;

FunctionCall : IDENTIFIER LPAREN Args RPAREN ;

Params: //empty
	     | IDENTIFIER COMMA Params
;

Args: //empty
		 | Expression COMMA Args
;

Statement : IfStatement
		 | ForStatement
		 | WhileStatement
;

IfStatement : KW_IF LPAREN Expression RPAREN KW_THEN Body KW_END
		 | KW_IF LPAREN Expression RPAREN KW_THEN Body KW_ELSE Body KW_END
;

ForStatement : KW_FOR LPAREN IDENTIFIER KW_IN Expression RPAREN KW_LOOP Body KW_END ;

WhileStatement : KW_WHILE LPAREN Expression RPAREN KW_LOOP Body KW_END ;

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
    return null;
  }

  @Override
  public int yylex () throws IOException{	
	int token = yylex.yylex();
    return token;
  }
}
