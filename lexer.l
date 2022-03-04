import java.util.*; 

%% 
%class LexerAnalysis
%standalone
%unicode
%type int
%line 
%column
%byaccj


/* main character classes */
LineTerminator 	=	\r|\n|\r\n
Letter 			=	[a-zA-Z]
LetterOrDigit	=	[a-zA-Z0-9]

WhiteSpace = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment}|{EndOfLineComment}

TraditionalComment	 = "/\**\*/"
EndOfLineComment	 = "//*{LineTerminator}?"

/* identifiers */
Identifier 			= {Letter}{LetterOrDigit}*

/* integer literals */
IntegerLiteral 		= 0 | [1-9][0-9]*
    
/* Real number literals */        
RealLiteral 		= ({FLit1}|{FLit2}|{FLit3}){Exponent}?[fF]

FLit1			    = [0-9]+\.[0-9]* 
FLit2			    = \.[0-9]+ 
FLit3			    = [0-9]+ 
Exponent			= [eE][+-]?[0-9]+

UNKNOWN_TOKEN = .

%state STRING

%% 
<YYINITIAL> {

  /* keywords */
  "is"                           { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.KW_IS; }
  "var"                          { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.KW_VAR; }
  "if"                           { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.KW_IF; }
  "then"                         { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.KW_THEN; }
  "else"                         { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.KW_ELSE; }
  "end"                          { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.KW_END; }
  "while"                        { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.KW_WHILE; }
  "for"                          { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.KW_FOR; }
  "in"                          { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.KW_IN; }
  "loop"                         { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.KW_LOOP; }
  "return"                       { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.KW_RETURN; }
  "print"                        { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.KW_PRINT; }
  "func"                        { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.KW_FUNC; }

  
  /* boolean literals */
  "true"                         { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.KW_TRUE; }
  "false"                        { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.KW_FALSE; }
  
  
  /* separators */
  "("                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.LPAREN; }
  ")"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.RPAREN; }
  "{"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.LBRACE; }
  "}"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.RBRACE; }
  "["                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.LBRACK; }
  "]"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.RBRACK; }
  ";"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.SEMICOLON; }
  ","                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.COMMA; }
  "."                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.DOT; }
  
  /* operators */
  "="                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.EQ; }
  ":="                           { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.ASSIGN; }
  ">"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.GT; }
  "<"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.LT; }
  "<="                           { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.LTEQ; }
  ">="                           { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.GTEQ; }
  "+"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.PLUS; }
  "-"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.MINUS; }
  "*"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.MULT; }
  "/"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.DIV; }
  "or"                           { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.OR; }
  "and"                          { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.AND; }
  "xor"                          { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.XOR; }
  "not"                          { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.NOT; }

  /* numeric literals */
  
  {IntegerLiteral}               { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.INTEGER_LITERAL; }
  {RealLiteral}                  { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.REAL_LITERAL; }
  {Identifier}				     { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.IDENTIFIER; }
  
  /* comments */
  {Comment}                      ;

  /* whitespace */
  {WhiteSpace}                   ;
  
  "\"([^\\\"\n\r]*\\[^\n\r])*\"" { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return Lexer.STRING; }
}

/* UNKNOWN TOKENS */
{UNKNOWN_TOKEN} 				 {return Lexer.UNKNOWN_TOKEN;}

/* error fallback */
[^]                              { throw new RuntimeException("Illegal character \""+yytext()+"\" at line "+yyline+", column "+yycolumn); }
<<EOF>>                          { return Lexer.EOF; }

