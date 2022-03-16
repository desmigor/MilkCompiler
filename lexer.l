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
  "is"                           { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_IS]"); return parser.ParserLexer.KW_IS; }
  "var"                          { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_VAR]"); return parser.ParserLexer.KW_VAR; }
  "if"                           { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_IF]"); return parser.ParserLexer.KW_IF; }
  "then"                         { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_THEN]"); return parser.ParserLexer.KW_THEN; }
  "else"                         { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_ELSE]"); return parser.ParserLexer.KW_ELSE; }
  "end"                          { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_END]"); return parser.ParserLexer.KW_END; }
  "while"                        { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_WHILE]"); return parser.ParserLexer.KW_WHILE; }
  "for"                          { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_FOR]"); return parser.ParserLexer.KW_FOR; }
  "loop"                         { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_LOOP]"); return parser.ParserLexer.KW_LOOP; }
  "return"                       { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_RETURN]"); return parser.ParserLexer.KW_RETURN; }
  "print"                        { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_PRINT]"); return parser.ParserLexer.KW_PRINT; }
  "funct"                        { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_FUNCT]"); return parser.ParserLexer.KW_FUNCT; }
  "in"                        { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : KW_IN]"); return parser.ParserLexer.KW_IN; }


  
  /* boolean literals */
  "true"                         { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : BOOLEAN_LITERAL]"); return parser.ParserLexer.BOOLEAN_LITERAL; }
  "false"                        { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : BOOLEAN_LITERAL]"); return parser.ParserLexer.BOOLEAN_LITERAL; }
  
  
  /* separators */
  "("                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : LPAREN]"); return parser.ParserLexer.LPAREN; }
  ")"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : RPAREN]"); return parser.ParserLexer.RPAREN; }
  "{"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : LBRACE]"); return parser.ParserLexer.LBRACE; }
  "}"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : RBRACE]"); return parser.ParserLexer.RBRACE; }
  "["                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : LBRACK]"); return parser.ParserLexer.LBRACK; }
  "]"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : RBRACK]"); return parser.ParserLexer.RBRACK; }
  ";"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : SEMICOLON]"); return parser.ParserLexer.SEMICOLON; }
  ","                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : COMMA]"); return parser.ParserLexer.COMMA; }
  "."                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : DOT]"); return parser.ParserLexer.DOT; }
  
  /* operators */
  "="                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : EQ]"); return parser.ParserLexer.EQ; }
  ":="                           { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : ASSIGN]"); return parser.ParserLexer.ASSIGN; }
  ">"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : GT]"); return parser.ParserLexer.GT; }
  "<"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : LT]");; return parser.ParserLexer.LT; }
  "<="                           { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : LTEQ]"); return parser.ParserLexer.LTEQ; }
  ">="                           { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : GTEQ]"); return parser.ParserLexer.GTEQ; }
  "+"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : PLUS]"); return parser.ParserLexer.PLUS; }
  "-"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : MINUS]"); return parser.ParserLexer.MINUS; }
  "*"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : MULT]");; return parser.ParserLexer.MULT; }
  "/"                            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : DIV]"); return parser.ParserLexer.DIV; }
  "=>"                           { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : EXPR]"); return parser.ParserLexer.EXPR; }
  "or"                           { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : TOKEN_OR]"); return parser.ParserLexer.TOKEN_OR; }
  "and"                          { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : TOKEN_AND]"); return parser.ParserLexer.TOKEN_AND; }
  "xor"                          { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : TOKEN_XOR]"); return parser.ParserLexer.TOKEN_XOR; }
  "not"                          { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : NOT]"); return parser.ParserLexer.TOKEN_NOT; }

  /* numeric literals */
  
  {IntegerLiteral}               { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : INTEGER_LITERAL]"); return parser.ParserLexer.INTEGER_LITERAL; }
  {RealLiteral}                  { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : REAL_LITERAL]"); return parser.ParserLexer.REAL_LITERAL; }
  
  /* comments */
  {Comment}                      { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : COMMENT]"); return parser.ParserLexer.COMMENT; }

  /* whitespace */
  {WhiteSpace}                   { }
  {Identifier}                   { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : IDENTIFIER]"); return parser.ParserLexer.IDENTIFIER; }
}

<STRING> {
  /*\"                             { yybegin(YYINITIAL); return parser.ParserLexer.STRING;}*/
  
  {StringCharacter}+            { System.out.println("[token at line " + yyline + " = \"" + yytext() + "\" : STRING]"); return parser.ParserLexer.STRING; }
  
  /* escape sequences */
  "\\n"                          { return parser.ParserLexer.STRING; }
  "\\\""                         { return parser.ParserLexer.STRING; }
  "\\'"                          { return parser.ParserLexer.STRING; }
  "\\\\"                         { return parser.ParserLexer.STRING; }
  
  /* error cases */
  \\.                            { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\""); }
  {LineTerminator}               { throw new RuntimeException("Unterminated string at end of line"); }
}

/* UNKNOWN TOKENS */
{UNKNOWN_TOKEN} {return parser.ParserLexer.UNKNOWN_TOKEN;}

/* error fallback */
[^]                              { throw new RuntimeException("Illegal character \""+yytext()+"\" at line "+yyline+", column "+yycolumn); }
<<EOF>>                          { return 0; }

