%define api.prefix {Parser}
%define api.parser.class {Parser}
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
    Parser p = new Parser(lexer);
    if(parser.parse())
      System.out.println("---------------------\n Parser Completed Successfully!");
    return;
  }
}

%left PLUS MINUS
%left MULT DIV

//All keywords
%token KW_IF KW_IS KW_VAR KW_END

//Boolean
%token BOOLEAN_LITERAL 

// Separators
%token LPAREN RPAREN LBRACE RBRACE LBRACK RBRACK SEMICOLON COMMA DOT

// Operators
%token EQ ASSIGN GT LT LTEQ GTEQ PLUS MINUS MULT DIV OR AND XOR NOT

// Numeric
%token INTEGER_LITERAL REAL_LITERAL

//Other tokens
%token COMMENT WHITESPACE STRING UNKNOWN_TOKEN EOF IDENTIFIER

%%


Prog : Body                              
;

Body : /* empty */                                    
     | Declaration Body                         
     | Statement Body                           
     | Expression Body                          
;

Declaration : KW_VAR IDENTIFIER SEMICOLON                                 
            | KW_VAR IDENTIFIER ASSIGN Expression SEMICOLON
			| KW_VAR IDENTIFIER ASSIGN FunctionDef SEMICOLON
;

Expression :
		 | FunctionCall
		 | Calc
		 | Relation
		 | IDENTIFIER
		 | Value
;

Relation :                                
           Expression LT Expression                    
         | Expression LTEQ Expression                  
         | Expression GT Expression                    
         | Expression GTEQ Expression                  
         | Expression EQ Expression                    
		 | Expression AND Expression
		 | Expression OR Expression
		 | Expression XOR Expression
		 | NOT Expression
;

Calc : 
		   Expression PLUS Expression
		 | Expression MINUS Expression
		 | Expression MULT Expression
		 | Expression DIV Expression
;

Value :
		   STRING
		 | INTEGER_LITERAL
		 | REAL_LITERAL
;
		 
FunctionDef : LPAREN Params RPAREN KW_IS Body KW_END 
;

FunctionCall : IDENTIFIER LPAREN Args RPAREN 
;

Params: //empty
	     | IDENTIFIER COMMA Params
;

Args: //empty
		 | Expression COMMA Args
;

%%

class ParserLexer implements Parser.Lexer {
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
