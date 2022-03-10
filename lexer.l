import java.util.*; 

%% 
/* %class lexer  */
%public
%standalone
%unicode
%line 
%column
%byaccj


/* main character classes */
LineTerminator = \r|\n|;|\r\n
InputCharacter = [^\r\n]

WhiteSpace = {LineTerminator} | [ \t\n\r]+

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment}

TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?

/* identifiers*/ 
Identifier = [:jletter:][:jletterdigit:]*

/* integer literals */
IntegerLiteral = 0 | [1-9][0-9]*
    
/* Real number literals */        
RealLiteral  = ({FLit1}|{FLit2}|{FLit3}) {Exponent}? [fF]

FLit1    = [0-9]+ \. [0-9]* 
FLit2    = \. [0-9]+ 
FLit3    = [0-9]+ 
Exponent = [eE] [+-]? [0-9]+


/* string literals */
StringCharacter = [a-zA-Z_]

UNKNOWN_TOKEN = .

%state STRING, CHARLITERAL

%% 
<YYINITIAL> {

  /* keywords */
  "is"                           { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_IS]"); return ParserLexer.KW_IS; }
  "var"                          { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_VAR]"); return ParserLexer.KW_VAR; }
  "if"                           { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_IF]"); return ParserLexer.KW_IF; }
  "then"                         { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_THEN]"); return ParserLexer.KW_THEN; }
  "else"                         { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_ELSE]"); return ParserLexer.KW_ELSE; }
  "end"                          { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_END]"); return ParserLexer.KW_END; }
  "while"                        { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_WHILE]"); return ParserLexer.KW_WHILE; }
  "for"                          { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_FOR]"); return ParserLexer.KW_FOR; }
  "loop"                         { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_LOOP]"); return ParserLexer.KW_LOOP; }
  "return"                       { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_RETURN]"); return ParserLexer.KW_RETURN; }
  "print"                        { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_PRINT]"); return ParserLexer.KW_PRINT; }
  "funct"                        { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_FUNCT]"); return ParserLexer.KW_FUNCT; }
  

  
  /* boolean literals */
  "true"                         { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : BOOLEAN_LITERAL]"); return ParserLexer.BOOLEAN_LITERAL; }
  "false"                        { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : BOOLEAN_LITERAL]"); return ParserLexer.BOOLEAN_LITERAL; }
  
  
  /* separators */
  "("                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : LPAREN]"); return ParserLexer.LPAREN; }
  ")"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : RPAREN]"); return ParserLexer.RPAREN; }
  "{"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : LBRACE]"); return ParserLexer.LBRACE; }
  "}"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : RBRACE]"); return ParserLexer.RBRACE; }
  "["                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : LBRACK]"); return ParserLexer.LBRACK; }
  "]"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : RBRACK]"); return ParserLexer.RBRACK; }
  ";"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : SEMICOLON]"); return ParserLexer.SEMICOLON; }
  ","                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : COMMA]"); return ParserLexer.COMMA; }
  "."                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : DOT]"); return ParserLexer.DOT; }
  
  /* operators */
  "="                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : EQ]"); return ParserLexer.EQ; }
  ":="                           { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : ASSIGN]"); return ParserLexer.ASSIGN; }
  ">"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : GT]"); return ParserLexer.GT; }
  "<"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : LT]");; return ParserLexer.LT; }
  "<="                           { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : LTEQ]"); return ParserLexer.LTEQ; }
  ">="                           { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : GTEQ]"); return ParserLexer.GTEQ; }
  "+"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : PLUS]"); return ParserLexer.PLUS; }
  "-"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : MINUS]"); return ParserLexer.MINUS; }
  "*"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : MULT]");; return ParserLexer.MULT; }
  "/"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : DIV]"); return ParserLexer.DIV; }
  "=>"                           { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : EXPR]"); return ParserLexer.EXPR; }
  "or"                           { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : TOKEN_OR]"); return ParserLexer.TOKEN_OR; }
  "and"                          { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : TOKEN_AND]"); return ParserLexer.TOKEN_AND; }
  "xor"                          { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : TOKEN_XOR]"); return ParserLexer.TOKEN_XOR; }
  "not"                          { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : NOT]"); return ParserLexer.TOKEN_NOT; }

  /* numeric literals */
  
  {IntegerLiteral}               { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : INTEGER_LITERAL]"); return ParserLexer.INTEGER_LITERAL; }
  {RealLiteral}                  { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : REAL_LITERAL]"); return ParserLexer.REAL_LITERAL; }
  
  /* comments */
  {Comment}                      { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : COMMENT]"); return ParserLexer.COMMENT; }

  /* whitespace */
  {WhiteSpace}                   { }
  {Identifier}                   { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : IDENTIFIER]"); return ParserLexer.IDENTIFIER; }
}

<STRING> {
  /*\"                             { yybegin(YYINITIAL); return ParserLexer.STRING;}*/
  
  {StringCharacter}+            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : STRING]"); return ParserLexer.STRING; }
  
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
<<EOF>>                          { return 0; }

