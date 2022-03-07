/* A Bison parser, made by GNU Bison 3.8.2.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018-2021 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */




import java.text.MessageFormat;
import java.util.ArrayList;
/* "%code imports" blocks.  */
/* "parser.y":6  */

  import java.io.InputStream;
  import java.io.InputStreamReader;
  import java.io.Reader;
  import java.io.IOException;
  import java.io.EOFException;

/* "parser.java":52  */

/**
 * A Bison parser, automatically generated from <tt>parser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class parser
{
  /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.8.2";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";



  /**
   * True if verbose error messages are enabled.
   */
  private boolean yyErrorVerbose = true;

  /**
   * Whether verbose error messages are enabled.
   */
  public final boolean getErrorVerbose() { return yyErrorVerbose; }

  /**
   * Set the verbosity of error messages.
   * @param verbose True to request verbose error messages.
   */
  public final void setErrorVerbose(boolean verbose)
  { yyErrorVerbose = verbose; }




  public enum SymbolKind
  {
    S_YYEOF(0),                    /* "end of file"  */
    S_YYerror(1),                  /* error  */
    S_YYUNDEF(2),                  /* "invalid token"  */
    S_KW_IF(3),                    /* KW_IF  */
    S_KW_IS(4),                    /* KW_IS  */
    S_KW_VAR(5),                   /* KW_VAR  */
    S_KW_END(6),                   /* KW_END  */
    S_KW_TRUE(7),                  /* KW_TRUE  */
    S_KW_FALSE(8),                 /* KW_FALSE  */
    S_KW_THEN(9),                  /* KW_THEN  */
    S_KW_ELSE(10),                 /* KW_ELSE  */
    S_KW_FOR(11),                  /* KW_FOR  */
    S_KW_LOOP(12),                 /* KW_LOOP  */
    S_KW_IN(13),                   /* KW_IN  */
    S_KW_WHILE(14),                /* KW_WHILE  */
    S_KW_FUNCT(15),                /* KW_FUNCT  */
    S_KW_RETURN(16),               /* KW_RETURN  */
    S_KW_PRINT(17),                /* KW_PRINT  */
    S_IDENTIFIER(18),              /* IDENTIFIER  */
    S_BOOLEAN_LITERAL(19),         /* BOOLEAN_LITERAL  */
    S_LPAREN(20),                  /* LPAREN  */
    S_RPAREN(21),                  /* RPAREN  */
    S_LBRACE(22),                  /* LBRACE  */
    S_RBRACE(23),                  /* RBRACE  */
    S_LBRACK(24),                  /* LBRACK  */
    S_RBRACK(25),                  /* RBRACK  */
    S_SEMICOLON(26),               /* SEMICOLON  */
    S_COMMA(27),                   /* COMMA  */
    S_DOT(28),                     /* DOT  */
    S_EQ(29),                      /* EQ  */
    S_ASSIGN(30),                  /* ASSIGN  */
    S_GT(31),                      /* GT  */
    S_LT(32),                      /* LT  */
    S_LTEQ(33),                    /* LTEQ  */
    S_GTEQ(34),                    /* GTEQ  */
    S_PLUS(35),                    /* PLUS  */
    S_MINUS(36),                   /* MINUS  */
    S_MULT(37),                    /* MULT  */
    S_DIV(38),                     /* DIV  */
    S_EXPR(39),                    /* EXPR  */
    S_TOKEN_OR(40),                /* TOKEN_OR  */
    S_TOKEN_AND(41),               /* TOKEN_AND  */
    S_TOKEN_XOR(42),               /* TOKEN_XOR  */
    S_TOKEN_NOT(43),               /* TOKEN_NOT  */
    S_INTEGER_LITERAL(44),         /* INTEGER_LITERAL  */
    S_REAL_LITERAL(45),            /* REAL_LITERAL  */
    S_COMMENT(46),                 /* COMMENT  */
    S_STRING(47),                  /* STRING  */
    S_UNKNOWN_TOKEN(48),           /* UNKNOWN_TOKEN  */
    S_TOKEN_EOF(49),               /* TOKEN_EOF  */
    S_YYACCEPT(50),                /* $accept  */
    S_Prog(51),                    /* Prog  */
    S_Body(52),                    /* Body  */
    S_Declaration(53),             /* Declaration  */
    S_ReturnStatement(54),         /* ReturnStatement  */
    S_PrintStatement(55),          /* PrintStatement  */
    S_Assignment(56),              /* Assignment  */
    S_Expression(57),              /* Expression  */
    S_ArrayAccess(58),             /* ArrayAccess  */
    S_Relation(59),                /* Relation  */
    S_Calc(60),                    /* Calc  */
    S_Value(61),                   /* Value  */
    S_ArrayValue(62),              /* ArrayValue  */
    S_DictValue(63),               /* DictValue  */
    S_DictValues(64),              /* DictValues  */
    S_ArrayValues(65),             /* ArrayValues  */
    S_FunctionDef(66),             /* FunctionDef  */
    S_FunctionCall(67),            /* FunctionCall  */
    S_Params(68),                  /* Params  */
    S_Args(69),                    /* Args  */
    S_Statement(70),               /* Statement  */
    S_IfStatement(71),             /* IfStatement  */
    S_ForStatement(72),            /* ForStatement  */
    S_WhileStatement(73);          /* WhileStatement  */


    private final int yycode_;

    SymbolKind (int n) {
      this.yycode_ = n;
    }

    private static final SymbolKind[] values_ = {
      SymbolKind.S_YYEOF,
      SymbolKind.S_YYerror,
      SymbolKind.S_YYUNDEF,
      SymbolKind.S_KW_IF,
      SymbolKind.S_KW_IS,
      SymbolKind.S_KW_VAR,
      SymbolKind.S_KW_END,
      SymbolKind.S_KW_TRUE,
      SymbolKind.S_KW_FALSE,
      SymbolKind.S_KW_THEN,
      SymbolKind.S_KW_ELSE,
      SymbolKind.S_KW_FOR,
      SymbolKind.S_KW_LOOP,
      SymbolKind.S_KW_IN,
      SymbolKind.S_KW_WHILE,
      SymbolKind.S_KW_FUNCT,
      SymbolKind.S_KW_RETURN,
      SymbolKind.S_KW_PRINT,
      SymbolKind.S_IDENTIFIER,
      SymbolKind.S_BOOLEAN_LITERAL,
      SymbolKind.S_LPAREN,
      SymbolKind.S_RPAREN,
      SymbolKind.S_LBRACE,
      SymbolKind.S_RBRACE,
      SymbolKind.S_LBRACK,
      SymbolKind.S_RBRACK,
      SymbolKind.S_SEMICOLON,
      SymbolKind.S_COMMA,
      SymbolKind.S_DOT,
      SymbolKind.S_EQ,
      SymbolKind.S_ASSIGN,
      SymbolKind.S_GT,
      SymbolKind.S_LT,
      SymbolKind.S_LTEQ,
      SymbolKind.S_GTEQ,
      SymbolKind.S_PLUS,
      SymbolKind.S_MINUS,
      SymbolKind.S_MULT,
      SymbolKind.S_DIV,
      SymbolKind.S_EXPR,
      SymbolKind.S_TOKEN_OR,
      SymbolKind.S_TOKEN_AND,
      SymbolKind.S_TOKEN_XOR,
      SymbolKind.S_TOKEN_NOT,
      SymbolKind.S_INTEGER_LITERAL,
      SymbolKind.S_REAL_LITERAL,
      SymbolKind.S_COMMENT,
      SymbolKind.S_STRING,
      SymbolKind.S_UNKNOWN_TOKEN,
      SymbolKind.S_TOKEN_EOF,
      SymbolKind.S_YYACCEPT,
      SymbolKind.S_Prog,
      SymbolKind.S_Body,
      SymbolKind.S_Declaration,
      SymbolKind.S_ReturnStatement,
      SymbolKind.S_PrintStatement,
      SymbolKind.S_Assignment,
      SymbolKind.S_Expression,
      SymbolKind.S_ArrayAccess,
      SymbolKind.S_Relation,
      SymbolKind.S_Calc,
      SymbolKind.S_Value,
      SymbolKind.S_ArrayValue,
      SymbolKind.S_DictValue,
      SymbolKind.S_DictValues,
      SymbolKind.S_ArrayValues,
      SymbolKind.S_FunctionDef,
      SymbolKind.S_FunctionCall,
      SymbolKind.S_Params,
      SymbolKind.S_Args,
      SymbolKind.S_Statement,
      SymbolKind.S_IfStatement,
      SymbolKind.S_ForStatement,
      SymbolKind.S_WhileStatement
    };

    static final SymbolKind get(int code) {
      return values_[code];
    }

    public final int getCode() {
      return this.yycode_;
    }

    /* Return YYSTR after stripping away unnecessary quotes and
       backslashes, so that it's suitable for yyerror.  The heuristic is
       that double-quoting is unnecessary unless the string contains an
       apostrophe, a comma, or backslash (other than backslash-backslash).
       YYSTR is taken from yytname.  */
    private static String yytnamerr_(String yystr)
    {
      if (yystr.charAt (0) == '"')
        {
          StringBuffer yyr = new StringBuffer();
          strip_quotes: for (int i = 1; i < yystr.length(); i++)
            switch (yystr.charAt(i))
              {
              case '\'':
              case ',':
                break strip_quotes;

              case '\\':
                if (yystr.charAt(++i) != '\\')
                  break strip_quotes;
                /* Fall through.  */
              default:
                yyr.append(yystr.charAt(i));
                break;

              case '"':
                return yyr.toString();
              }
        }
      return yystr;
    }

    /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
       First, the terminals, then, starting at \a YYNTOKENS_, nonterminals.  */
    private static final String[] yytname_ = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "\"end of file\"", "error", "\"invalid token\"", "KW_IF", "KW_IS",
  "KW_VAR", "KW_END", "KW_TRUE", "KW_FALSE", "KW_THEN", "KW_ELSE",
  "KW_FOR", "KW_LOOP", "KW_IN", "KW_WHILE", "KW_FUNCT", "KW_RETURN",
  "KW_PRINT", "IDENTIFIER", "BOOLEAN_LITERAL", "LPAREN", "RPAREN",
  "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMICOLON", "COMMA", "DOT",
  "EQ", "ASSIGN", "GT", "LT", "LTEQ", "GTEQ", "PLUS", "MINUS", "MULT",
  "DIV", "EXPR", "TOKEN_OR", "TOKEN_AND", "TOKEN_XOR", "TOKEN_NOT",
  "INTEGER_LITERAL", "REAL_LITERAL", "COMMENT", "STRING", "UNKNOWN_TOKEN",
  "TOKEN_EOF", "$accept", "Prog", "Body", "Declaration", "ReturnStatement",
  "PrintStatement", "Assignment", "Expression", "ArrayAccess", "Relation",
  "Calc", "Value", "ArrayValue", "DictValue", "DictValues", "ArrayValues",
  "FunctionDef", "FunctionCall", "Params", "Args", "Statement",
  "IfStatement", "ForStatement", "WhileStatement", null
    };
  }

    /* The user-facing name of this symbol.  */
    public final String getName() {
      return yytnamerr_(yytname_[yycode_]);
    }

  };


  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>parser</tt>.
   */
  public interface Lexer {
    /* Token kinds.  */
    /** Token "end of file", to be returned by the scanner.  */
    static final int YYEOF = 0;
    /** Token error, to be returned by the scanner.  */
    static final int YYerror = 256;
    /** Token "invalid token", to be returned by the scanner.  */
    static final int YYUNDEF = 257;
    /** Token KW_IF, to be returned by the scanner.  */
    static final int KW_IF = 258;
    /** Token KW_IS, to be returned by the scanner.  */
    static final int KW_IS = 259;
    /** Token KW_VAR, to be returned by the scanner.  */
    static final int KW_VAR = 260;
    /** Token KW_END, to be returned by the scanner.  */
    static final int KW_END = 261;
    /** Token KW_TRUE, to be returned by the scanner.  */
    static final int KW_TRUE = 262;
    /** Token KW_FALSE, to be returned by the scanner.  */
    static final int KW_FALSE = 263;
    /** Token KW_THEN, to be returned by the scanner.  */
    static final int KW_THEN = 264;
    /** Token KW_ELSE, to be returned by the scanner.  */
    static final int KW_ELSE = 265;
    /** Token KW_FOR, to be returned by the scanner.  */
    static final int KW_FOR = 266;
    /** Token KW_LOOP, to be returned by the scanner.  */
    static final int KW_LOOP = 267;
    /** Token KW_IN, to be returned by the scanner.  */
    static final int KW_IN = 268;
    /** Token KW_WHILE, to be returned by the scanner.  */
    static final int KW_WHILE = 269;
    /** Token KW_FUNCT, to be returned by the scanner.  */
    static final int KW_FUNCT = 270;
    /** Token KW_RETURN, to be returned by the scanner.  */
    static final int KW_RETURN = 271;
    /** Token KW_PRINT, to be returned by the scanner.  */
    static final int KW_PRINT = 272;
    /** Token IDENTIFIER, to be returned by the scanner.  */
    static final int IDENTIFIER = 273;
    /** Token BOOLEAN_LITERAL, to be returned by the scanner.  */
    static final int BOOLEAN_LITERAL = 274;
    /** Token LPAREN, to be returned by the scanner.  */
    static final int LPAREN = 275;
    /** Token RPAREN, to be returned by the scanner.  */
    static final int RPAREN = 276;
    /** Token LBRACE, to be returned by the scanner.  */
    static final int LBRACE = 277;
    /** Token RBRACE, to be returned by the scanner.  */
    static final int RBRACE = 278;
    /** Token LBRACK, to be returned by the scanner.  */
    static final int LBRACK = 279;
    /** Token RBRACK, to be returned by the scanner.  */
    static final int RBRACK = 280;
    /** Token SEMICOLON, to be returned by the scanner.  */
    static final int SEMICOLON = 281;
    /** Token COMMA, to be returned by the scanner.  */
    static final int COMMA = 282;
    /** Token DOT, to be returned by the scanner.  */
    static final int DOT = 283;
    /** Token EQ, to be returned by the scanner.  */
    static final int EQ = 284;
    /** Token ASSIGN, to be returned by the scanner.  */
    static final int ASSIGN = 285;
    /** Token GT, to be returned by the scanner.  */
    static final int GT = 286;
    /** Token LT, to be returned by the scanner.  */
    static final int LT = 287;
    /** Token LTEQ, to be returned by the scanner.  */
    static final int LTEQ = 288;
    /** Token GTEQ, to be returned by the scanner.  */
    static final int GTEQ = 289;
    /** Token PLUS, to be returned by the scanner.  */
    static final int PLUS = 290;
    /** Token MINUS, to be returned by the scanner.  */
    static final int MINUS = 291;
    /** Token MULT, to be returned by the scanner.  */
    static final int MULT = 292;
    /** Token DIV, to be returned by the scanner.  */
    static final int DIV = 293;
    /** Token EXPR, to be returned by the scanner.  */
    static final int EXPR = 294;
    /** Token TOKEN_OR, to be returned by the scanner.  */
    static final int TOKEN_OR = 295;
    /** Token TOKEN_AND, to be returned by the scanner.  */
    static final int TOKEN_AND = 296;
    /** Token TOKEN_XOR, to be returned by the scanner.  */
    static final int TOKEN_XOR = 297;
    /** Token TOKEN_NOT, to be returned by the scanner.  */
    static final int TOKEN_NOT = 298;
    /** Token INTEGER_LITERAL, to be returned by the scanner.  */
    static final int INTEGER_LITERAL = 299;
    /** Token REAL_LITERAL, to be returned by the scanner.  */
    static final int REAL_LITERAL = 300;
    /** Token COMMENT, to be returned by the scanner.  */
    static final int COMMENT = 301;
    /** Token STRING, to be returned by the scanner.  */
    static final int STRING = 302;
    /** Token UNKNOWN_TOKEN, to be returned by the scanner.  */
    static final int UNKNOWN_TOKEN = 303;
    /** Token TOKEN_EOF, to be returned by the scanner.  */
    static final int TOKEN_EOF = 304;

    /** Deprecated, use YYEOF instead.  */
    public static final int EOF = YYEOF;


    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex() throws java.io.IOException;

    /**
     * Emit an errorin a user-defined way.
     *
     *
     * @param msg The string for the error message.
     */
     void yyerror(String msg);


  }


  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;





  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public parser(Lexer yylexer)
  {

    this.yylexer = yylexer;

  }



  private int yynerrs = 0;

  /**
   * The number of syntax errors so far.
   */
  public final int getNumberOfErrors() { return yynerrs; }

  /**
   * Print an error message via the lexer.
   *
   * @param msg The error message.
   */
  public final void yyerror(String msg) {
      yylexer.yyerror(msg);
  }



  private final class YYStack {
    private int[] stateStack = new int[16];
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push(int state, Object value) {
      height++;
      if (size == height) {
        int[] newStateStack = new int[size * 2];
        System.arraycopy(stateStack, 0, newStateStack, 0, height);
        stateStack = newStateStack;

        Object[] newValueStack = new Object[size * 2];
        System.arraycopy(valueStack, 0, newValueStack, 0, height);
        valueStack = newValueStack;

        size *= 2;
      }

      stateStack[height] = state;
      valueStack[height] = value;
    }

    public final void pop() {
      pop(1);
    }

    public final void pop(int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (0 < num) {
        java.util.Arrays.fill(valueStack, height - num + 1, height + 1, null);
      }
      height -= num;
    }

    public final int stateAt(int i) {
      return stateStack[height - i];
    }

    public final Object valueAt(int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print(java.io.PrintStream out) {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++) {
        out.print(' ');
        out.print(stateStack[i]);
      }
      out.println();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yyLRGotoState(int yystate, int yysym) {
    int yyr = yypgoto_[yysym - YYNTOKENS_] + yystate;
    if (0 <= yyr && yyr <= YYLAST_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - YYNTOKENS_];
  }

  private int yyaction(int yyn, YYStack yystack, int yylen)
  {
    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    Object yyval = (0 < yylen) ? yystack.valueAt(yylen - 1) : yystack.valueAt(0);

    switch (yyn)
      {
        
/* "parser.java":625  */

        default: break;
      }

    yystack.pop(yylen);
    yylen = 0;
    /* Shift the result of the reduction.  */
    int yystate = yyLRGotoState(yystack.stateAt(0), yyr1_[yyn]);
    yystack.push(yystate, yyval);
    return YYNEWSTATE;
  }




  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
  public boolean parse() throws java.io.IOException

  {


    /* Lookahead token kind.  */
    int yychar = YYEMPTY_;
    /* Lookahead symbol kind.  */
    SymbolKind yytoken = null;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;



    /* Semantic value of the lookahead.  */
    Object yylval = null;



    yyerrstatus_ = 0;
    yynerrs = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval);



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:

        /* Accept?  */
        if (yystate == YYFINAL_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yyPactValueIsDefault (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == YYEMPTY_)
          {

            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal();

          }

        /* Convert token to internal form.  */
        yytoken = yytranslate_ (yychar);

        if (yytoken == SymbolKind.S_YYerror)
          {
            // The scanner already issued an error message, process directly
            // to error recovery.  But do not keep the error token as
            // lookahead, it is too special and may lead us to an endless
            // loop in error recovery. */
            yychar = Lexer.YYUNDEF;
            yytoken = SymbolKind.S_YYUNDEF;
            label = YYERRLAB1;
          }
        else
          {
            /* If the proper action on seeing token YYTOKEN is to reduce or to
               detect an error, take that action.  */
            yyn += yytoken.getCode();
            if (yyn < 0 || YYLAST_ < yyn || yycheck_[yyn] != yytoken.getCode()) {
              label = YYDEFAULT;
            }

            /* <= 0 means reduce or error.  */
            else if ((yyn = yytable_[yyn]) <= 0)
              {
                if (yyTableValueIsError(yyn)) {
                  label = YYERRLAB;
                } else {
                  yyn = -yyn;
                  label = YYREDUCE;
                }
              }

            else
              {
                /* Shift the lookahead token.  */
                /* Discard the token being shifted.  */
                yychar = YYEMPTY_;

                /* Count tokens shifted since error; after three, turn off error
                   status.  */
                if (yyerrstatus_ > 0)
                  --yyerrstatus_;

                yystate = yyn;
                yystack.push(yystate, yylval);
                label = YYNEWSTATE;
              }
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction(yyn, yystack, yylen);
        yystate = yystack.stateAt(0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs;
            if (yychar == YYEMPTY_)
              yytoken = null;
            yyreportSyntaxError(new Context(this, yystack, yytoken));
          }

        if (yyerrstatus_ == 3)
          {
            /* If just tried and failed to reuse lookahead token after an
               error, discard it.  */

            if (yychar <= Lexer.YYEOF)
              {
                /* Return failure if at end of input.  */
                if (yychar == Lexer.YYEOF)
                  return false;
              }
            else
              yychar = YYEMPTY_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt(0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        // Pop stack until we find a state that shifts the error token.
        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yyPactValueIsDefault (yyn))
              {
                yyn += SymbolKind.S_YYerror.getCode();
                if (0 <= yyn && yyn <= YYLAST_
                    && yycheck_[yyn] == SymbolKind.S_YYerror.getCode())
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;


            yystack.pop ();
            yystate = yystack.stateAt(0);
          }

        if (label == YYABORT)
          /* Leave the switch.  */
          break;



        /* Shift the error token.  */

        yystate = yyn;
        yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  /**
   * Information needed to get the list of expected tokens and to forge
   * a syntax error diagnostic.
   */
  public static final class Context {
    Context(parser parser, YYStack stack, SymbolKind token) {
      yyparser = parser;
      yystack = stack;
      yytoken = token;
    }

    private parser yyparser;
    private YYStack yystack;


    /**
     * The symbol kind of the lookahead token.
     */
    public final SymbolKind getToken() {
      return yytoken;
    }

    private SymbolKind yytoken;
    static final int NTOKENS = parser.YYNTOKENS_;

    /**
     * Put in YYARG at most YYARGN of the expected tokens given the
     * current YYCTX, and return the number of tokens stored in YYARG.  If
     * YYARG is null, return the number of expected tokens (guaranteed to
     * be less than YYNTOKENS).
     */
    int getExpectedTokens(SymbolKind yyarg[], int yyargn) {
      return getExpectedTokens (yyarg, 0, yyargn);
    }

    int getExpectedTokens(SymbolKind yyarg[], int yyoffset, int yyargn) {
      int yycount = yyoffset;
      int yyn = yypact_[this.yystack.stateAt(0)];
      if (!yyPactValueIsDefault(yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative
             indexes in YYCHECK.  In other words, skip the first
             -YYN actions for this state because they are default
             actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST_ - yyn + 1;
          int yyxend = yychecklim < NTOKENS ? yychecklim : NTOKENS;
          for (int yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck_[yyx + yyn] == yyx && yyx != SymbolKind.S_YYerror.getCode()
                && !yyTableValueIsError(yytable_[yyx + yyn]))
              {
                if (yyarg == null)
                  yycount += 1;
                else if (yycount == yyargn)
                  return 0; // FIXME: this is incorrect.
                else
                  yyarg[yycount++] = SymbolKind.get(yyx);
              }
        }
      if (yyarg != null && yycount == yyoffset && yyoffset < yyargn)
        yyarg[yycount] = null;
      return yycount - yyoffset;
    }
  }




  private int yysyntaxErrorArguments(Context yyctx, SymbolKind[] yyarg, int yyargn) {
    /* There are many possibilities here to consider:
       - If this state is a consistent state with a default action,
         then the only way this function was invoked is if the
         default action is an error action.  In that case, don't
         check for expected tokens because there are none.
       - The only way there can be no lookahead present (in tok) is
         if this state is a consistent state with a default action.
         Thus, detecting the absence of a lookahead is sufficient to
         determine that there is no unexpected or expected token to
         report.  In that case, just report a simple "syntax error".
       - Don't assume there isn't a lookahead just because this
         state is a consistent state with a default action.  There
         might have been a previous inconsistent state, consistent
         state with a non-default action, or user semantic action
         that manipulated yychar.  (However, yychar is currently out
         of scope during semantic actions.)
       - Of course, the expected token list depends on states to
         have correct lookahead information, and it depends on the
         parser not to perform extra reductions after fetching a
         lookahead from the scanner and before detecting a syntax
         error.  Thus, state merging (from LALR or IELR) and default
         reductions corrupt the expected token list.  However, the
         list is correct for canonical LR with one exception: it
         will still contain any token that will not be accepted due
         to an error action in a later state.
    */
    int yycount = 0;
    if (yyctx.getToken() != null)
      {
        if (yyarg != null)
          yyarg[yycount] = yyctx.getToken();
        yycount += 1;
        yycount += yyctx.getExpectedTokens(yyarg, 1, yyargn);
      }
    return yycount;
  }


  /**
   * Build and emit a "syntax error" message in a user-defined way.
   *
   * @param ctx  The context of the error.
   */
  private void yyreportSyntaxError(Context yyctx) {
      if (yyErrorVerbose) {
          final int argmax = 5;
          SymbolKind[] yyarg = new SymbolKind[argmax];
          int yycount = yysyntaxErrorArguments(yyctx, yyarg, argmax);
          String[] yystr = new String[yycount];
          for (int yyi = 0; yyi < yycount; ++yyi) {
              yystr[yyi] = yyarg[yyi].getName();
          }
          String yyformat;
          switch (yycount) {
              default:
              case 0: yyformat = "syntax error"; break;
              case 1: yyformat = "syntax error, unexpected {0}"; break;
              case 2: yyformat = "syntax error, unexpected {0}, expecting {1}"; break;
              case 3: yyformat = "syntax error, unexpected {0}, expecting {1} or {2}"; break;
              case 4: yyformat = "syntax error, unexpected {0}, expecting {1} or {2} or {3}"; break;
              case 5: yyformat = "syntax error, unexpected {0}, expecting {1} or {2} or {3} or {4}"; break;
          }
          yyerror(new MessageFormat(yyformat).format(yystr));
      } else {
          yyerror("syntax error");
      }
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yyPactValueIsDefault(int yyvalue) {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yyTableValueIsError(int yyvalue) {
    return yyvalue == yytable_ninf_;
  }

  private static final short yypact_ninf_ = -30;
  private static final short yytable_ninf_ = -1;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
      86,   -12,    -8,   -30,   -30,    -1,    12,   104,   104,    19,
     104,    15,   104,   104,   -30,   -30,   -30,    41,   -30,    21,
     -30,    36,    37,   206,   -30,   -30,   -30,   -30,   -30,   -30,
     -30,    86,   -30,   -30,   -30,   104,    38,    27,   104,    51,
     -20,   -20,   104,   104,   121,    42,    49,    59,   225,    58,
      97,   -30,    86,    86,    86,   104,    86,   104,   104,   104,
     104,   104,   104,   104,   104,   104,   104,   104,   104,   -30,
     143,    22,    72,   165,   244,    69,   -20,   -30,    15,   -30,
     104,   -30,   -30,   -30,   -30,   263,   -30,    97,    94,    94,
      94,    94,   278,   278,    46,    46,     2,    77,   103,    96,
      87,   -20,   -30,   104,   101,   104,   -30,   -30,   -30,   -30,
      86,    91,   187,    86,   -30,    28,    88,    93,   105,   110,
     -30,    86,    91,   115,    86,   -30,   114,   -30,    86,   119,
     -30,   126,   -30,   -30
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte[] yydefact_ = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
       3,     0,     0,    40,    41,     0,     0,     0,     0,    16,
       0,    46,    48,     0,    38,    39,    37,     0,     2,     0,
       9,     0,     0,     0,    22,    18,    21,    19,    42,    43,
      20,     3,    56,    57,    58,     0,    10,     0,     0,    16,
      13,    14,    54,     0,     0,     0,     0,     0,     0,     0,
      32,     1,     3,     3,     3,     0,     3,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     8,
       0,     0,     0,     0,     0,     0,    15,    17,    46,    45,
      48,    44,     4,     7,     5,     0,     6,    28,    26,    24,
      25,    27,    33,    34,    35,    36,    30,    29,    31,     0,
       0,    11,    12,     0,     0,    54,    51,    47,    49,    23,
       3,    52,     0,     3,    55,     0,     0,     0,     0,     0,
      59,     3,    52,     0,     3,    62,     0,    53,     3,     0,
      60,     0,    61,    50
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte[] yypgoto_ = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -30,   -30,   -29,   -30,   -30,   -30,    -4,    -7,   -30,   -30,
     -30,   -30,   -30,   -30,    62,    61,   -30,   -30,    24,    55,
     -30,   -30,   -30,   -30
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte[] yydefgoto_ = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
       0,    17,    18,    19,    20,    21,    22,    23,    24,    25,
      26,    27,    28,    29,    47,    49,   102,    30,   117,    75,
      31,    32,    33,    34
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final short[] yytable_ = yytable_init();
  private static final short[] yytable_init()
  {
    return new short[]
    {
      40,    41,    69,    44,    55,    48,    50,    46,    35,    57,
      36,    58,    59,    60,    61,    62,    63,    64,    65,    37,
      66,    67,    68,    82,    83,    84,    55,    86,    70,     3,
       4,    73,    38,    45,   120,    74,    76,   100,   121,    42,
      39,    51,    10,    67,    11,    72,    12,    52,    85,    43,
      87,    88,    89,    90,    91,    92,    93,    94,    95,    96,
      97,    98,    53,    54,   101,    13,    14,    15,    71,    16,
      55,    42,    43,    48,    46,    57,    78,    58,    59,    60,
      61,   115,    79,    81,   119,   103,    66,    67,    68,     1,
     106,     2,   126,     3,     4,   129,   112,     5,    74,   131,
       6,    55,     7,     8,     9,   110,    10,   111,    11,   116,
      12,     3,     4,   113,   123,   122,   125,   124,    55,   128,
     130,    55,    39,    57,    10,   132,    11,    55,    12,    13,
      14,    15,   133,    16,    66,    67,    68,    66,    67,    68,
     107,   108,    77,    66,    67,    55,   127,    13,    14,    15,
      57,    16,    58,    59,    60,    61,    62,    63,    64,    65,
     114,    66,    67,    68,    99,     0,     0,    55,     0,     0,
       0,     0,    57,     0,    58,    59,    60,    61,    62,    63,
      64,    65,     0,    66,    67,    68,   104,     0,     0,    55,
       0,     0,     0,     0,    57,     0,    58,    59,    60,    61,
      62,    63,    64,    65,     0,    66,    67,    68,   118,     0,
       0,    55,     0,     0,     0,     0,    57,     0,    58,    59,
      60,    61,    62,    63,    64,    65,     0,    66,    67,    68,
      55,     0,    56,     0,     0,    57,     0,    58,    59,    60,
      61,    62,    63,    64,    65,     0,    66,    67,    68,    55,
       0,     0,    80,     0,    57,     0,    58,    59,    60,    61,
      62,    63,    64,    65,     0,    66,    67,    68,    55,     0,
       0,   105,     0,    57,     0,    58,    59,    60,    61,    62,
      63,    64,    65,     0,    66,    67,    68,    55,   109,     0,
       0,     0,    57,     0,    58,    59,    60,    61,    62,    63,
      64,    65,    55,    66,    67,    68,     0,    57,     0,    58,
      59,    60,    61,     0,     0,    64,    65,     0,    66,    67,
      68
    };
  }

private static final short[] yycheck_ = yycheck_init();
  private static final short[] yycheck_init()
  {
    return new short[]
    {
       7,     8,    31,    10,    24,    12,    13,    11,    20,    29,
      18,    31,    32,    33,    34,    35,    36,    37,    38,    20,
      40,    41,    42,    52,    53,    54,    24,    56,    35,     7,
       8,    38,    20,    18,     6,    42,    43,    15,    10,    20,
      18,     0,    20,    41,    22,    18,    24,    26,    55,    30,
      57,    58,    59,    60,    61,    62,    63,    64,    65,    66,
      67,    68,    26,    26,    71,    43,    44,    45,    30,    47,
      24,    20,    30,    80,    78,    29,    27,    31,    32,    33,
      34,   110,    23,    25,   113,    13,    40,    41,    42,     3,
      21,     5,   121,     7,     8,   124,   103,    11,   105,   128,
      14,    24,    16,    17,    18,     9,    20,    20,    22,    18,
      24,     7,     8,    12,    21,    27,     6,    12,    24,     4,
       6,    24,    18,    29,    20,     6,    22,    24,    24,    43,
      44,    45,     6,    47,    40,    41,    42,    40,    41,    42,
      78,    80,    21,    40,    41,    24,   122,    43,    44,    45,
      29,    47,    31,    32,    33,    34,    35,    36,    37,    38,
     105,    40,    41,    42,    21,    -1,    -1,    24,    -1,    -1,
      -1,    -1,    29,    -1,    31,    32,    33,    34,    35,    36,
      37,    38,    -1,    40,    41,    42,    21,    -1,    -1,    24,
      -1,    -1,    -1,    -1,    29,    -1,    31,    32,    33,    34,
      35,    36,    37,    38,    -1,    40,    41,    42,    21,    -1,
      -1,    24,    -1,    -1,    -1,    -1,    29,    -1,    31,    32,
      33,    34,    35,    36,    37,    38,    -1,    40,    41,    42,
      24,    -1,    26,    -1,    -1,    29,    -1,    31,    32,    33,
      34,    35,    36,    37,    38,    -1,    40,    41,    42,    24,
      -1,    -1,    27,    -1,    29,    -1,    31,    32,    33,    34,
      35,    36,    37,    38,    -1,    40,    41,    42,    24,    -1,
      -1,    27,    -1,    29,    -1,    31,    32,    33,    34,    35,
      36,    37,    38,    -1,    40,    41,    42,    24,    25,    -1,
      -1,    -1,    29,    -1,    31,    32,    33,    34,    35,    36,
      37,    38,    24,    40,    41,    42,    -1,    29,    -1,    31,
      32,    33,    34,    -1,    -1,    37,    38,    -1,    40,    41,
      42
    };
  }

/* YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of
   state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     3,     5,     7,     8,    11,    14,    16,    17,    18,
      20,    22,    24,    43,    44,    45,    47,    51,    52,    53,
      54,    55,    56,    57,    58,    59,    60,    61,    62,    63,
      67,    70,    71,    72,    73,    20,    18,    20,    20,    18,
      57,    57,    20,    30,    57,    18,    56,    64,    57,    65,
      57,     0,    26,    26,    26,    24,    26,    29,    31,    32,
      33,    34,    35,    36,    37,    38,    40,    41,    42,    52,
      57,    30,    18,    57,    57,    69,    57,    21,    27,    23,
      27,    25,    52,    52,    52,    57,    52,    57,    57,    57,
      57,    57,    57,    57,    57,    57,    57,    57,    57,    21,
      15,    57,    66,    13,    21,    27,    21,    64,    65,    25,
       9,    20,    57,    12,    69,    52,    18,    68,    21,    52,
       6,    10,    27,    21,    12,     6,    52,    68,     4,    52,
       6,    52,     6,     6
    };
  }

/* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    50,    51,    52,    52,    52,    52,    52,    52,    52,
      53,    53,    53,    54,    55,    56,    57,    57,    57,    57,
      57,    57,    57,    58,    59,    59,    59,    59,    59,    59,
      59,    59,    59,    60,    60,    60,    60,    61,    61,    61,
      61,    61,    61,    61,    62,    63,    64,    64,    65,    65,
      66,    67,    68,    68,    69,    69,    70,    70,    70,    71,
      71,    72,    73
    };
  }

/* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     1,     0,     3,     3,     3,     3,     2,     1,
       2,     4,     4,     2,     2,     3,     1,     3,     1,     1,
       1,     1,     1,     4,     3,     3,     3,     3,     3,     3,
       3,     3,     2,     3,     3,     3,     3,     1,     1,     1,
       1,     1,     1,     1,     3,     3,     0,     3,     0,     3,
       7,     4,     0,     3,     0,     3,     1,     1,     1,     7,
       9,     9,     7
    };
  }




  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
    // Last valid token kind.
    int code_max = 304;
    if (t <= 0)
      return SymbolKind.S_YYEOF;
    else if (t <= code_max)
      return SymbolKind.get(yytranslate_table_[t]);
    else
      return SymbolKind.S_YYUNDEF;
  }
  private static final byte[] yytranslate_table_ = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,    44,
      45,    46,    47,    48,    49
    };
  }


  private static final int YYLAST_ = 320;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 51;
  private static final int YYNTOKENS_ = 50;

/* Unqualified %code blocks.  */
/* "parser.y":15  */

  public static void main(String args[]) throws IOException {
    ParserLexer lexer = new ParserLexer(System.in);
    parser p = new parser(lexer);
    if(p.parse())
      System.out.println("---------------------\n Parser Completed Successfully!");
    return;
  }

/* "parser.java":1326  */

}
/* "parser.y":169  */


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
