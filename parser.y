%define api.prefix {parser}
%define api.parser.class {parser}
%define api.parser.public
%define parse.error verbose

%code imports{
  import java.io.InputStream;
  import java.io.InputStreamReader;
  import java.io.Reader;
  import java.io.IOException;
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
%token EQ ASSIGN GT LT LTEQ GTEQ PLUS MINUS MULT DIV EXPR TOKEN_OR TOKEN_AND TOKEN_XOR

// Numeric
%token INTEGER_LITERAL REAL_LITERAL

//Other tokens
%token COMMENT WHITESPACE STRING UNKNOWN_TOKEN TOKEN_EOF

%%  
prog : /*empty*/

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
