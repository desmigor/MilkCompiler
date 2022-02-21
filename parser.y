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

//All keywords
%token KEYWORD 

//Boolean
%token BOOLEAN_LITERAL 

// Separators
%token LPAREN RPAREN LBRACE RBRACE LBRACK RBRACK SEMICOLON COMMA DOT

// Operators
%token EQ ASSIGN GT LT LTEQ GTEQ PLUS MINUS MULT DIV EXPR TOKEN_OR TOKEN_AND TOKEN_XOR

// Numeric
%token INTEGER_LITERAL REAL_LITERAL

//Other tokens
%token COMMENT WHITESPACE STRING UNKNOWN_TOKEN EOF

// TYpe declaration
%union {
  //Node *node;
  NProgram *program;
  NInstruction *instruction;
  NBlock *block;
  NDeclaration *declaration;
  NArray *array;
  NTuple *tuple;
  NStatement *statement;
  NAssignment *assignment;
  NPrint *print;
  NFunctionDefinition *funcdef;
  NParameters *param;
  NIf *ifstmt;
  NIfElse *ifelse;
  NLoop *loop;
  NReturn *returnstmt;

  NExpression *expression;
  NIdentifier *identifier;
  NIntegerLiteral *integer_lit;
  NReal *real;
  NBool *boolstmt;
  NStringLiteral *string_lit;
  NBinaryOperator *binaryop;
  NTypeCheck *typecheck;
  NUnary *unary;
  NReadInput *readinput;
  std::vector<NDeclaration*> *variableVector;
  std::vector<NStatement*> *statementVector;
  std::vector<NExpression*> *expressionVector;
  std::vector<NIdentifier*> *paramVector;

  std::string *string;
  int token;
}

%type <block> Body LoopBody Prog
%type <declaration> Declaration 
%type <statement> Statement 
%type <expression> Expression Relation Factor Term Unary Primary Literal 
%type <funcdef> FunctionLiteral
%type <expression> ArrayLiteral TupleLiteral
%type <statement> Assignment Return If Loop
%type <print> Print Expressions 
%type <param> Identifiers Parameters
%type <string> TypeIndicator

%%
Prog : Body                              
;

Body : /* empty */                                        //{$$ = NULL; }
     | Declaration Body                         
     | Statement Body                           
     | Expression Body                          
;

Declaration : KEYWORD STRING SEMICOLON                                 
            | KEYWORD STRING ASSIGN Expression SEMICOLON     
;

Expression : Relation                           
           | Relation TOKEN_AND Relation                  {$$ = $1 && $3; }
           | Relation TOKEN_OR Relation                   {$$ = $1 || $3; }
           | Relation TOKEN_XOR Relation                  {$$ = ($1 || $3)&&(!$1 || !$3); }
;

Relation : Factor                               
         | Factor LT Factor                       {$$ = $1 < $3; }
         | Factor LTEQ Factor                        {$$ = $1 <= $3; }
         | Factor GT Factor                      {$$ = $1 > $3; }
         | Factor GTEQ Factor                        {$$ = $1 >= $3; }
         | Factor EQ Factor                      {$$ = $1 == $3; }
;

Factor : Term                                   
       | Term PLUS Factor                           {$$ = $1 + $3; }
       | Term MINUS Factor                          {$$ = $1 - $3; }
;

Term : Unary                                    
     | Unary MULT Term                              {$$ = $1 * $3; }
     | Unary DIV Term                               {$$ = $1 / $3; }
;

Unary : Primary                                 
      | PLUS Primary                      
      | MINUS Primary                                          
      | Literal                                 
      | LPAREN Expression RPAREN    
      | PLUS Primary KEYWORD TypeIndicator           
      | MINUS Primary KEYWORD TypeIndicator                     
      | Primary KEYWORD TypeIndicator                      
;

Primary : TOKEN_IDENTIFIER Tails
        | TOKEN_READINT                                     {scanf("%d", &$1); $$ = $1; }
        | TOKEN_READREAL                                    //{scanf("%f", &$1); $$ = $1; }
        | TOKEN_READSTRING                                  //{scanf("%s", $1); $$ = $1; }
;

Tails : /* empty */                                         //{$$ = NULL; }
        | Tail Tails                           
;

Tail : TOKEN_DOT TOKEN_INT_LITERAL                   
     | TOKEN_DOT TOKEN_IDENTIFIER               
     | TOKEN_LSQUARE Expression TOKEN_RSQUARE   
     | TOKEN_LPAREN Expressions TOKEN_RPAREN    
;

Statement : Assignment                         
          | Print                              
          | Return                             
          | If                                 
          | Loop                               
;

Assignment : Primary TOKEN_ASSIGNMENT Expression TOKEN_SEMI   //{$$ = $1 = $3; }   
;

Print : TOKEN_PRINT Expressions TOKEN_SEMI                
;

Expressions : Expression                        
            | Expression TOKEN_COMMA Expressions      
;

Return : TOKEN_RETURN Expression TOKEN_SEMI                   //{$$ = return $2; }             
       | TOKEN_RETURN TOKEN_SEMI                              //{$$ = NULL; }  
;

If : TOKEN_IF Expression TOKEN_THEN Body TOKEN_END            //{$$ = if_statement($2, $4, NULL); }
   | TOKEN_IF Expression TOKEN_THEN Body TOKEN_ELSE Body TOKEN_END      //{$$ = if_statement($2, $4, $6); }
;

Loop : TOKEN_WHILE Expression LoopBody                        
     | TOKEN_FOR TOKEN_IDENTIFIER TOKEN_IN TypeIndicator LoopBody             
;

LoopBody : TOKEN_LOOP Body TOKEN_END            
;

TypeIndicator : TOKEN_INT                                     //{$$ = "int";}                   
              | TOKEN_REAL                                    //{$$ = "float";}
              | TOKEN_BOOL                                    //{$$ = "bool";}
              | TOKEN_STRING                                  //{$$ = "string";}
              | TOKEN_EMPTY                                   //{$$ = "empty";}
              | ArrayLiteral                    
              | TupleLiteral                    
              | TOKEN_FUNC                      
;

Literal : TOKEN_INT_LITERAL                     
        | TOKEN_REAL_LITERAL                    
        | TOKEN_TRUE                            
        | TOKEN_FALSE                           
        | TOKEN_STRING_LITERAL                  
        | ArrayLiteral                          
        | TupleLiteral
        | FunctionLiteral                          
;

ArrayLiteral : TOKEN_LSQUARE TOKEN_RSQUARE      
             | TOKEN_LSQUARE Expressions TOKEN_RSQUARE      
;

TupleLiteral : TOKEN_LCURLY TOKEN_RCURLY
             | TOKEN_LCURLY TOKEN_IDENTIFIER TupleTail
             | TOKEN_LCURLY TOKEN_IDENTIFIER TOKEN_ASSIGNMENT Expression TupleTail
;

TupleTail : TOKEN_RCURLY
          | TOKEN_COMMA TOKEN_IDENTIFIER TupleTail
          | TOKEN_COMMA TOKEN_IDENTIFIER TOKEN_ASSIGNMENT Expression TupleTail
;

FunctionLiteral : TOKEN_FUNC FunBody            
                | TOKEN_FUNC Parameters FunBody 
;

Parameters : TOKEN_LPAREN Identifiers TOKEN_RPAREN        
;

Identifiers : TOKEN_IDENTIFIER                  
            | TOKEN_IDENTIFIER TOKEN_COMMA Identifiers            
FunBody : TOKEN_IS Body TOKEN_END               
        | TOKEN_FUNCTOR Expression              
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
