import java.util.*; 

%% 
%class lexer
%standalone
%unicode
%type JavaType
%line 
%column
%byaccj


/* main character classes */
LineTerminator = \r|\n|;|\r\n
InputCharacter = [^\r\n]

WhiteSpace = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment}

TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?

/* identifiers 
Identifier = [:jletter:][:jletterdigit:]* */

/* integer literals */
IntegerLiteral = 0 | [1-9][0-9]*
    
/* Real number literals */        
RealLiteral  = ({FLit1}|{FLit2}|{FLit3}) {Exponent}? [fF]

FLit1    = [0-9]+ \. [0-9]* 
FLit2    = \. [0-9]+ 
FLit3    = [0-9]+ 
Exponent = [eE] [+-]? [0-9]+


/* string literals */
StringCharacter = [^\r\n\"\\]
SingleCharacter = [^\r\n\'\\]

UNKNOWN_TOKEN = .

%state STRING, CHARLITERAL

%% 
<YYINITIAL> {

  /* keywords */
  "is"                           { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.KEYWORD; }
  "var"                          { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.KEYWORD; }
  "if"                           { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.KEYWORD; }
  "then"                         { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.KEYWORD; }
  "then"                         { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.KEYWORD; }
  "else"                         { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.KEYWORD; }
  "end"                          { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.KEYWORD; }
  "while"                        { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.KEYWORD; }
  "for"                          { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.KEYWORD; }
  "loop"                         { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.KEYWORD; }
  "return"                       { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.KEYWORD; }
  "print"                        { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.KEYWORD; }
  "funct"                        { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.KEYWORD; }

  
  /* boolean literals */
  "true"                         { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.BOOLEAN_LITERAL; }
  "false"                        { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.BOOLEAN_LITERAL; }
  
  
  /* separators */
  "("                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.LPAREN; }
  ")"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.RPAREN; }
  "{"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.LBRACE; }
  "}"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.RBRACE; }
  "["                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.LBRACK; }
  "]"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.RBRACK; }
  ";"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.SEMICOLON; }
  ","                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.COMMA; }
  "."                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.DOT; }
  
  /* operators */
  "="                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.EQ; }
  ":="                           { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.ASSIGN; }
  ">"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.GT; }
  "<"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.LT; }
  "<="                           { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.LTEQ; }
  ">="                           { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.GTEQ; }
  "+"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.PLUS; }
  "-"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.MINUS; }
  "*"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.MULT; }
  "/"                            { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.DIV; }
  "=>"                           { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.EXPR; }
  "or"                           { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.TOKEN_OR; }
  "and"                          { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.TOKEN_AND; }
  "xor"                          { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.TOKEN_XOR; }

  /* numeric literals */
  
  {IntegerLiteral}               { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.INTEGER_LITERAL; }
  {RealLiteral}                  { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.REAL_LITERAL; }
  
  /* comments */
  {Comment}                      { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.COMMENT; }

  /* whitespace */
  {WhiteSpace}                   { return ParserLexer.WHITESPACE; }

<STRING> {
  \"                             { yybegin(YYINITIAL); return ParserLexer.STRING  }
  
  {StringCharacter}+             { System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ParserLexer.STRING; }
  
  /* escape sequences */
  "\\n"                          { return ParserLexer.STRING; }
  "\\\""                         { return ParserLexer.STRING; }
  "\\'"                          { return ParserLexer.STRING; }
  "\\\\"                         { return ParserLexer.STRING; }
  
  /* error cases */
  \\.                            { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\""); }
  {LineTerminator}               { throw new RuntimeException("Unterminated string at end of line"); }
}

/* UNKNOWN TOKENS */
{UNKNOWN_TOKEN} {return ParserLexer.UNKNOWN_TOKEN;}

/* error fallback */
[^]                              { throw new RuntimeException("Illegal character \""+yytext()+"\" at line "+yyline+", column "+yycolumn); }
<<EOF>>                          { return ParserLexer.EOF; }

