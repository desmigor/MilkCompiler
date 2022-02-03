import java.util.*; 
%% 
%class lexer
%standalone
%unicode
%type JavaType
%line 
%column
%byaccj

%{ 
  List<String> tokens = new ArrayList();
  /* store a reference to the parser object */
  private parser yyparser;

  /* constructor taking an additional parser object */
  public Yylex(java.io.Reader r, parser yyparser) {
    this(r);
    this.yyparser = yyparser;
  }
%}

%eof{ 
  System.out.println("Lexical Analyzer:"); 
  for(int i=0;i<tokens.size();i++){  
    System.out.println(tokens.get(i)); 
  } 
%eof}

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
/* SingleCharacter = [^\r\n\'\\] */

/* Array literals */

/* Tuple literals */

/* Funct literals */

%state STRING, CHARLITERAL

%% 
<YYINITIAL> {

  /* keywords */
  "is"                           { tokens.add(yytext() + " = KEYWORD"); return parser.KEYWORD; }
  "var"                          { tokens.add(yytext() + " = KEYWORD"); return parser.KEYWORD; }
  "if"                           { tokens.add(yytext() + " = KEYWORD"); return parser.KEYWORD; }
  "then"                         { tokens.add(yytext() + " = KEYWORD"); return parser.KEYWORD; }
  "then"                         { tokens.add(yytext() + " = KEYWORD"); return parser.KEYWORD; }
  "else"                         { tokens.add(yytext() + " = KEYWORD"); return parser.KEYWORD; }
  "end"                          { tokens.add(yytext() + " = KEYWORD"); return parser.KEYWORD; }
  "while"                        { tokens.add(yytext() + " = KEYWORD"); return parser.KEYWORD; }
  "for"                          { tokens.add(yytext() + " = KEYWORD"); return parser.KEYWORD; }
  "loop"                         { tokens.add(yytext() + " = KEYWORD"); return parser.KEYWORD; }
  "return"                       { tokens.add(yytext() + " = KEYWORD"); return parser.KEYWORD; }
  "print"                        { tokens.add(yytext() + " = KEYWORD"); return parser.KEYWORD; }
  "or"                           { tokens.add(yytext() + " = KEYWORD"); return parser.KEYWORD; }
  "and"                          { tokens.add(yytext() + " = KEYWORD"); return parser.KEYWORD; }
  "xor"                          { tokens.add(yytext() + " = KEYWORD"); return parser.KEYWORD; }
  "funct"                        { tokens.add(yytext() + " = KEYWORD"); return parser.KEYWORD; }

  
  /* boolean literals */
  "true"                         { tokens.add(yytext() + " = BOOLEAN"); return JavaType.BOOLEAN_LITERAL; }
  "false"                        { tokens.add(yytext() + " = BOOLEAN"); return JavaType.BOOLEAN_LITERAL; }
  
  
  /* separators */
  "("                            { tokens.add(yytext() + " = LPAREN"); return JavaType.LPAREN; }
  ")"                            { tokens.add(yytext() + " = RPAREN"); return JavaType.RPAREN; }
  "{"                            { tokens.add(yytext() + " = LBRACE"); return JavaType.LBRACE; }
  "}"                            { tokens.add(yytext() + " = RBRACE"); return JavaType.RBRACE; }
  "["                            { tokens.add(yytext() + " = LBRACK"); return JavaType.LBRACK; }
  "]"                            { tokens.add(yytext() + " = RBRACK"); return JavaType.RBRACK; }
  ";"                            { tokens.add(yytext() + " = SEMICOLON"); return JavaType.SEMICOLON; }
  ","                            { tokens.add(yytext() + " = COMMA"); return JavaType.COMMA; }
  "."                            { tokens.add(yytext() + " = DOT"); return JavaType.DOT; }
  
  /* operators */
  "="                            { tokens.add(yytext() + " = EQUAL"); return JavaType.EQ; }
  ":="                           { tokens.add(yytext() + " = ASSIGNMENT"); return JavaType.ASSIGN; }
  ">"                            { tokens.add(yytext() + " = GT"); return JavaType.GT; }
  "<"                            { tokens.add(yytext() + " = LT"); return JavaType.LT; }
  "<="                           { tokens.add(yytext() + " = LTEQ"); return JavaType.LTEQ; }
  ">="                           { tokens.add(yytext() + " = GTEQ"); return JavaType.GTEQ; }
  "+"                            { tokens.add(yytext() + " = PLUS"); return JavaType.PLUS; }
  "-"                            { tokens.add(yytext() + " = MINUS"); return JavaType.MINUS; }
  "*"                            { tokens.add(yytext() + " = MULT"); return JavaType.MULT; }
  "/"                            { tokens.add(yytext() + " = DIV"); return JavaType.DIV; }
  "=>"                           { tokens.add(yytext() + " = EXPR"); return JavaType.EXPR; }

  /* string literal */
  \"                             { yybegin(STRING); return JavaType.STRING; }

  /* numeric literals */

  /* This is matched together with the minus, because the number is too big to 
     be represented by a positive integer. */
  "-2147483648"                  { tokens.add(yytext() + " = INTEGER"); return JavaType.INTEGER_LITERAL; }
  
  {IntegerLiteral}               { tokens.add(yytext() + " = INTEGER"); return JavaType.INTEGER_LITERAL; }
  
  {RealLiteral}                  { tokens.add(yytext() + " = REAL"); return JavaType.FLOATING_POINT_LITERAL; }
  
  /* comments */
  {Comment}                      { tokens.add(yytext() + " = COMMENT"); return JavaType.COMMENT; }

  /* whitespace */
  {WhiteSpace}                   { return JavaType.WHITESPACE; }

  /* identifiers  
  {Identifier}                   {  return JavaType.IDENTIFIER; } */
}

<STRING> {
  \"                             { yybegin(YYINITIAL);return JavaType.STRING;  }
  
  {StringCharacter}+             { tokens.add(yytext() + " = STRING"); return JavaType.STRING; }
  
  /* escape sequences */
  "\\n"                          { tokens.add(yytext() + " = ESCAPE"); return JavaType.STRING; }
  "\\\""                         { return JavaType.STRING; }
  "\\'"                          { return JavaType.STRING; }
  "\\\\"                         { return JavaType.STRING; }
  
  /* error cases */
  \\.                            { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\""); }
  {LineTerminator}               { throw new RuntimeException("Unterminated string at end of line"); }
}

/* error fallback */
[^]                              { throw new RuntimeException("Illegal character \""+yytext()+"\" at line "+yyline+", column "+yycolumn); }
<<EOF>>                          {  return JavaType.EOF; }

