/* A Bison parser, made by GNU Bison 3.7.4.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018-2020 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

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

package Parser;



import java.text.MessageFormat;
/* "%code imports" blocks.  */
/* "parser.y":7  */

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.IOException;

/* "parser.java":51  */

/**
 * A Bison parser, automatically generated from <tt>parser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class Parser
{
  /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.7.4";

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
    S_KW_FUNC(15),                 /* KW_FUNC  */
    S_KW_RETURN(16),               /* KW_RETURN  */
    S_KW_PRINT(17),                /* KW_PRINT  */
    S_LPAREN(18),                  /* LPAREN  */
    S_RPAREN(19),                  /* RPAREN  */
    S_LBRACE(20),                  /* LBRACE  */
    S_RBRACE(21),                  /* RBRACE  */
    S_LBRACK(22),                  /* LBRACK  */
    S_RBRACK(23),                  /* RBRACK  */
    S_SEMICOLON(24),               /* SEMICOLON  */
    S_COMMA(25),                   /* COMMA  */
    S_DOT(26),                     /* DOT  */
    S_EQ(27),                      /* EQ  */
    S_ASSIGN(28),                  /* ASSIGN  */
    S_GT(29),                      /* GT  */
    S_LT(30),                      /* LT  */
    S_LTEQ(31),                    /* LTEQ  */
    S_GTEQ(32),                    /* GTEQ  */
    S_PLUS(33),                    /* PLUS  */
    S_MINUS(34),                   /* MINUS  */
    S_MULT(35),                    /* MULT  */
    S_DIV(36),                     /* DIV  */
    S_OR(37),                      /* OR  */
    S_AND(38),                     /* AND  */
    S_XOR(39),                     /* XOR  */
    S_NOT(40),                     /* NOT  */
    S_INTEGER_LITERAL(41),         /* INTEGER_LITERAL  */
    S_REAL_LITERAL(42),            /* REAL_LITERAL  */
    S_STRING(43),                  /* STRING  */
    S_IDENTIFIER(44),              /* IDENTIFIER  */
    S_YYACCEPT(45),                /* $accept  */
    S_Prog(46),                    /* Prog  */
    S_Body(47),                    /* Body  */
    S_Declaration(48),             /* Declaration  */
    S_ReturnStatement(49),         /* ReturnStatement  */
    S_PrintStatement(50),          /* PrintStatement  */
    S_Assignment(51),              /* Assignment  */
    S_Expression(52),              /* Expression  */
    S_ArrayAccess(53),             /* ArrayAccess  */
    S_Relation(54),                /* Relation  */
    S_Calc(55),                    /* Calc  */
    S_Value(56),                   /* Value  */
    S_ArrayValue(57),              /* ArrayValue  */
    S_DictValue(58),               /* DictValue  */
    S_DictValues(59),              /* DictValues  */
    S_ArrayValues(60),             /* ArrayValues  */
    S_FunctionDef(61),             /* FunctionDef  */
    S_FunctionCall(62),            /* FunctionCall  */
    S_Params(63),                  /* Params  */
    S_Args(64),                    /* Args  */
    S_Statement(65),               /* Statement  */
    S_IfStatement(66),             /* IfStatement  */
    S_ForStatement(67),            /* ForStatement  */
    S_WhileStatement(68);          /* WhileStatement  */


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
            SymbolKind.S_KW_FUNC,
            SymbolKind.S_KW_RETURN,
            SymbolKind.S_KW_PRINT,
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
            SymbolKind.S_OR,
            SymbolKind.S_AND,
            SymbolKind.S_XOR,
            SymbolKind.S_NOT,
            SymbolKind.S_INTEGER_LITERAL,
            SymbolKind.S_REAL_LITERAL,
            SymbolKind.S_STRING,
            SymbolKind.S_IDENTIFIER,
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
                      "KW_FOR", "KW_LOOP", "KW_IN", "KW_WHILE", "KW_FUNC", "KW_RETURN",
                      "KW_PRINT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK",
                      "SEMICOLON", "COMMA", "DOT", "EQ", "ASSIGN", "GT", "LT", "LTEQ", "GTEQ",
                      "PLUS", "MINUS", "MULT", "DIV", "OR", "AND", "XOR", "NOT",
                      "INTEGER_LITERAL", "REAL_LITERAL", "STRING", "IDENTIFIER", "$accept",
                      "Prog", "Body", "Declaration", "ReturnStatement", "PrintStatement",
                      "Assignment", "Expression", "ArrayAccess", "Relation", "Calc", "Value",
                      "ArrayValue", "DictValue", "DictValues", "ArrayValues", "FunctionDef",
                      "FunctionCall", "Params", "Args", "Statement", "IfStatement",
                      "ForStatement", "WhileStatement", null
              };
    }

    /* The user-facing name of this symbol.  */
    public final String getName() {
      return yytnamerr_(yytname_[yycode_]);
    }

  };


  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>Parser</tt>.
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
    /** Token KW_FUNC, to be returned by the scanner.  */
    static final int KW_FUNC = 270;
    /** Token KW_RETURN, to be returned by the scanner.  */
    static final int KW_RETURN = 271;
    /** Token KW_PRINT, to be returned by the scanner.  */
    static final int KW_PRINT = 272;
    /** Token LPAREN, to be returned by the scanner.  */
    static final int LPAREN = 273;
    /** Token RPAREN, to be returned by the scanner.  */
    static final int RPAREN = 274;
    /** Token LBRACE, to be returned by the scanner.  */
    static final int LBRACE = 275;
    /** Token RBRACE, to be returned by the scanner.  */
    static final int RBRACE = 276;
    /** Token LBRACK, to be returned by the scanner.  */
    static final int LBRACK = 277;
    /** Token RBRACK, to be returned by the scanner.  */
    static final int RBRACK = 278;
    /** Token SEMICOLON, to be returned by the scanner.  */
    static final int SEMICOLON = 279;
    /** Token COMMA, to be returned by the scanner.  */
    static final int COMMA = 280;
    /** Token DOT, to be returned by the scanner.  */
    static final int DOT = 281;
    /** Token EQ, to be returned by the scanner.  */
    static final int EQ = 282;
    /** Token ASSIGN, to be returned by the scanner.  */
    static final int ASSIGN = 283;
    /** Token GT, to be returned by the scanner.  */
    static final int GT = 284;
    /** Token LT, to be returned by the scanner.  */
    static final int LT = 285;
    /** Token LTEQ, to be returned by the scanner.  */
    static final int LTEQ = 286;
    /** Token GTEQ, to be returned by the scanner.  */
    static final int GTEQ = 287;
    /** Token PLUS, to be returned by the scanner.  */
    static final int PLUS = 288;
    /** Token MINUS, to be returned by the scanner.  */
    static final int MINUS = 289;
    /** Token MULT, to be returned by the scanner.  */
    static final int MULT = 290;
    /** Token DIV, to be returned by the scanner.  */
    static final int DIV = 291;
    /** Token OR, to be returned by the scanner.  */
    static final int OR = 292;
    /** Token AND, to be returned by the scanner.  */
    static final int AND = 293;
    /** Token XOR, to be returned by the scanner.  */
    static final int XOR = 294;
    /** Token NOT, to be returned by the scanner.  */
    static final int NOT = 295;
    /** Token INTEGER_LITERAL, to be returned by the scanner.  */
    static final int INTEGER_LITERAL = 296;
    /** Token REAL_LITERAL, to be returned by the scanner.  */
    static final int REAL_LITERAL = 297;
    /** Token STRING, to be returned by the scanner.  */
    static final int STRING = 298;
    /** Token IDENTIFIER, to be returned by the scanner.  */
    static final int IDENTIFIER = 299;

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
  public Parser (Lexer yylexer)
  {

    this.yylexer = yylexer;

  }



  private int yynerrs = 0;

  /**
   * The number of syntax errors so far.
   */
  public final int getNumberOfErrors () { return yynerrs; }

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

    public final void push (int state, Object value) {
      height++;
      if (size == height)
      {
        int[] newStateStack = new int[size * 2];
        System.arraycopy (stateStack, 0, newStateStack, 0, height);
        stateStack = newStateStack;

        Object[] newValueStack = new Object[size * 2];
        System.arraycopy (valueStack, 0, newValueStack, 0, height);
        valueStack = newValueStack;

        size *= 2;
      }

      stateStack[height] = state;
      valueStack[height] = value;
    }

    public final void pop () {
      pop (1);
    }

    public final void pop (int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (0 < num) {
        java.util.Arrays.fill (valueStack, height - num + 1, height + 1, null);
      }
      height -= num;
    }

    public final int stateAt (int i) {
      return stateStack[height - i];
    }

    public final Object valueAt (int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print (java.io.PrintStream out) {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++)
      {
        out.print (' ');
        out.print (stateStack[i]);
      }
      out.println ();
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
  private int yyLRGotoState (int yystate, int yysym)
  {
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

      /* "parser.java":606  */

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
            if (yyn < 0 || YYLAST_ < yyn || yycheck_[yyn] != yytoken.getCode())
              label = YYDEFAULT;

              /* <= 0 means reduce or error.  */
            else if ((yyn = yytable_[yyn]) <= 0)
            {
              if (yyTableValueIsError (yyn))
                label = YYERRLAB;
              else
              {
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
              yystack.push (yystate, yylval);
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
          yystate = yystack.stateAt (0);
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
            yyreportSyntaxError (new Context (yystack, yytoken));
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
          yystate = yystack.stateAt (0);
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
            yystate = yystack.stateAt (0);
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
  public static final class Context
  {
    Context (YYStack stack, SymbolKind token)
    {
      yystack = stack;
      yytoken = token;
    }

    private YYStack yystack;


    /**
     * The symbol kind of the lookahead token.
     */
    public final SymbolKind getToken ()
    {
      return yytoken;
    }

    private SymbolKind yytoken;
    static final int NTOKENS = Parser.YYNTOKENS_;

    /**
     * Put in YYARG at most YYARGN of the expected tokens given the
     * current YYCTX, and return the number of tokens stored in YYARG.  If
     * YYARG is null, return the number of expected tokens (guaranteed to
     * be less than YYNTOKENS).
     */
    int getExpectedTokens (SymbolKind yyarg[], int yyargn)
    {
      return getExpectedTokens (yyarg, 0, yyargn);
    }

    int getExpectedTokens (SymbolKind yyarg[], int yyoffset, int yyargn)
    {
      int yycount = yyoffset;
      int yyn = yypact_[this.yystack.stateAt (0)];
      if (!yyPactValueIsDefault (yyn))
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


  private int yysyntaxErrorArguments (Context yyctx, SymbolKind[] yyarg, int yyargn)
  {
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
  private static boolean yyPactValueIsDefault (int yyvalue)
  {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yyTableValueIsError (int yyvalue)
  {
    return yyvalue == yytable_ninf_;
  }

  private static final short yypact_ninf_ = -44;
  private static final short yytable_ninf_ = -1;

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
     STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
            {
                    87,    -6,   -33,   -44,   -44,    -3,    -2,   130,   130,   130,
                    -31,   130,   130,   -44,   -44,   -44,    -9,    18,   -44,    10,
                    -44,    12,    17,   127,   -44,   -44,   -44,   -44,   -44,   -44,
                    -44,    87,   -44,   -44,   -44,   130,    -8,   -23,   130,    24,
                    291,   237,   -44,   156,    20,    25,     1,   255,    40,    77,
                    130,   130,   -44,    87,    87,    87,   130,    87,   130,   130,
                    130,   130,   130,   130,   130,   130,   130,   130,   130,   130,
                    -44,   177,   103,    53,   198,   130,   -44,   -31,   -44,   130,
                    -44,    48,   291,   -44,   -44,   -44,   273,   -44,    77,    42,
                    42,    42,    42,   309,   309,     8,     8,    -5,    49,   -14,
                    61,    56,   291,   -44,   130,    63,   -44,   -44,   -44,   -44,
                    -44,    87,    32,   219,    87,     4,    52,    59,    70,    78,
                    -44,    87,    32,    81,    87,   -44,    82,   -44,    87,    83,
                    -44,    85,   -44,   -44
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
                    3,     0,     0,    40,    41,     0,     0,     0,    54,     0,
                    46,    48,     0,    38,    39,    37,    16,     0,     2,     0,
                    9,     0,     0,     0,    22,    18,    21,    19,    42,    43,
                    20,     3,    56,    57,    58,     0,    10,     0,     0,    16,
                    13,     0,    14,     0,     0,     0,     0,     0,     0,    32,
                    54,     0,     1,     3,     3,     3,     0,     3,     0,     0,
                    0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
                    8,     0,     0,     0,     0,    54,    17,    46,    45,    48,
                    44,     0,    15,     4,     7,     5,     0,     6,    28,    26,
                    24,    25,    27,    33,    34,    35,    36,    30,    29,    31,
                    0,     0,    11,    12,     0,     0,    55,    47,    49,    51,
                    23,     3,    52,     0,     3,     0,     0,     0,     0,     0,
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
                    -44,   -44,   -28,   -44,   -44,   -44,    -4,    -7,   -44,   -44,
                    -44,   -44,   -44,   -44,    29,    23,   -44,   -44,   -35,   -43,
                    -44,   -44,   -44,   -44
            };
  }

  /* YYDEFGOTO[NTERM-NUM].  */
  private static final byte[] yydefgoto_ = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
            {
                    -1,    17,    18,    19,    20,    21,    22,    23,    24,    25,
                    26,    27,    28,    29,    46,    48,   103,    30,   117,    42,
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
                    40,    41,    43,    70,    47,    49,    45,    81,    56,    50,
                    120,    36,    35,    44,   121,    37,    38,    56,    52,    51,
                    72,    73,    78,    67,    68,    83,    84,    85,    71,    87,
                    56,    74,   106,    68,    53,    58,    54,    59,    60,    61,
                    62,    55,    50,    41,    82,    67,    68,    69,    51,    86,
                    77,    88,    89,    90,    91,    92,    93,    94,    95,    96,
                    97,    98,    99,    80,    56,   102,   104,   109,    41,    58,
                    111,    56,    47,    45,   112,   114,   116,   122,   123,    67,
                    68,    69,   124,   115,   125,   128,   119,   127,   130,   132,
                    1,   133,     2,   126,     3,     4,   129,   113,     5,    56,
                    131,     6,   108,     7,     8,     9,   107,    10,     0,    11,
                    3,     4,     0,     0,    67,    68,    69,     0,   101,     0,
                    0,     9,     0,    10,     0,    11,     0,    12,    13,    14,
                    15,    16,     0,     0,     0,     0,     0,     3,     4,     0,
                    0,     0,     0,    12,    13,    14,    15,    39,     9,    56,
                    10,    57,    11,     0,    58,     0,    59,    60,    61,    62,
                    63,    64,    65,    66,    67,    68,    69,     0,     0,     0,
                    12,    13,    14,    15,    39,    76,     0,     0,    56,     0,
                    0,     0,     0,    58,     0,    59,    60,    61,    62,    63,
                    64,    65,    66,    67,    68,    69,   100,     0,     0,    56,
                    0,     0,     0,     0,    58,     0,    59,    60,    61,    62,
                    63,    64,    65,    66,    67,    68,    69,   105,     0,     0,
                    56,     0,     0,     0,     0,    58,     0,    59,    60,    61,
                    62,    63,    64,    65,    66,    67,    68,    69,   118,     0,
                    0,    56,     0,     0,     0,     0,    58,     0,    59,    60,
                    61,    62,    63,    64,    65,    66,    67,    68,    69,    56,
                    0,     0,    75,     0,    58,     0,    59,    60,    61,    62,
                    63,    64,    65,    66,    67,    68,    69,    56,     0,     0,
                    79,     0,    58,     0,    59,    60,    61,    62,    63,    64,
                    65,    66,    67,    68,    69,    56,   110,     0,     0,     0,
                    58,     0,    59,    60,    61,    62,    63,    64,    65,    66,
                    67,    68,    69,    56,     0,     0,     0,     0,    58,     0,
                    59,    60,    61,    62,    63,    64,    65,    66,    67,    68,
                    69,    56,     0,     0,     0,     0,    58,     0,    59,    60,
                    61,    62,     0,     0,    65,    66,    67,    68,    69
            };
  }

  private static final short[] yycheck_ = yycheck_init();
  private static final short[] yycheck_init()
  {
    return new short[]
            {
                    7,     8,     9,    31,    11,    12,    10,    50,    22,    18,
                    6,    44,    18,    44,    10,    18,    18,    22,     0,    28,
                    28,    44,    21,    37,    38,    53,    54,    55,    35,    57,
                    22,    38,    75,    38,    24,    27,    24,    29,    30,    31,
                    32,    24,    18,    50,    51,    37,    38,    39,    28,    56,
                    25,    58,    59,    60,    61,    62,    63,    64,    65,    66,
                    67,    68,    69,    23,    22,    72,    13,    19,    75,    27,
                    9,    22,    79,    77,    18,    12,    44,    25,    19,    37,
                    38,    39,    12,   111,     6,     4,   114,   122,     6,     6,
                    3,     6,     5,   121,     7,     8,   124,   104,    11,    22,
                    128,    14,    79,    16,    17,    18,    77,    20,    -1,    22,
                    7,     8,    -1,    -1,    37,    38,    39,    -1,    15,    -1,
                    -1,    18,    -1,    20,    -1,    22,    -1,    40,    41,    42,
                    43,    44,    -1,    -1,    -1,    -1,    -1,     7,     8,    -1,
                    -1,    -1,    -1,    40,    41,    42,    43,    44,    18,    22,
                    20,    24,    22,    -1,    27,    -1,    29,    30,    31,    32,
                    33,    34,    35,    36,    37,    38,    39,    -1,    -1,    -1,
                    40,    41,    42,    43,    44,    19,    -1,    -1,    22,    -1,
                    -1,    -1,    -1,    27,    -1,    29,    30,    31,    32,    33,
                    34,    35,    36,    37,    38,    39,    19,    -1,    -1,    22,
                    -1,    -1,    -1,    -1,    27,    -1,    29,    30,    31,    32,
                    33,    34,    35,    36,    37,    38,    39,    19,    -1,    -1,
                    22,    -1,    -1,    -1,    -1,    27,    -1,    29,    30,    31,
                    32,    33,    34,    35,    36,    37,    38,    39,    19,    -1,
                    -1,    22,    -1,    -1,    -1,    -1,    27,    -1,    29,    30,
                    31,    32,    33,    34,    35,    36,    37,    38,    39,    22,
                    -1,    -1,    25,    -1,    27,    -1,    29,    30,    31,    32,
                    33,    34,    35,    36,    37,    38,    39,    22,    -1,    -1,
                    25,    -1,    27,    -1,    29,    30,    31,    32,    33,    34,
                    35,    36,    37,    38,    39,    22,    23,    -1,    -1,    -1,
                    27,    -1,    29,    30,    31,    32,    33,    34,    35,    36,
                    37,    38,    39,    22,    -1,    -1,    -1,    -1,    27,    -1,
                    29,    30,    31,    32,    33,    34,    35,    36,    37,    38,
                    39,    22,    -1,    -1,    -1,    -1,    27,    -1,    29,    30,
                    31,    32,    -1,    -1,    35,    36,    37,    38,    39
            };
  }

  /* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
     symbol of state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
            {
                    0,     3,     5,     7,     8,    11,    14,    16,    17,    18,
                    20,    22,    40,    41,    42,    43,    44,    46,    47,    48,
                    49,    50,    51,    52,    53,    54,    55,    56,    57,    58,
                    62,    65,    66,    67,    68,    18,    44,    18,    18,    44,
                    52,    52,    64,    52,    44,    51,    59,    52,    60,    52,
                    18,    28,     0,    24,    24,    24,    22,    24,    27,    29,
                    30,    31,    32,    33,    34,    35,    36,    37,    38,    39,
                    47,    52,    28,    44,    52,    25,    19,    25,    21,    25,
                    23,    64,    52,    47,    47,    47,    52,    47,    52,    52,
                    52,    52,    52,    52,    52,    52,    52,    52,    52,    52,
                    19,    15,    52,    61,    13,    19,    64,    59,    60,    19,
                    23,     9,    18,    52,    12,    47,    44,    63,    19,    47,
                    6,    10,    25,    19,    12,     6,    47,    63,     4,    47,
                    6,    47,     6,     6
            };
  }

  /* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
            {
                    0,    45,    46,    47,    47,    47,    47,    47,    47,    47,
                    48,    48,    48,    49,    50,    51,    52,    52,    52,    52,
                    52,    52,    52,    53,    54,    54,    54,    54,    54,    54,
                    54,    54,    54,    55,    55,    55,    55,    56,    56,    56,
                    56,    56,    56,    56,    57,    58,    59,    59,    60,    60,
                    61,    62,    63,    63,    64,    64,    65,    65,    65,    66,
                    66,    67,    68
            };
  }

  /* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
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
    int code_max = 299;
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
                    35,    36,    37,    38,    39,    40,    41,    42,    43,    44
            };
  }


  private static final int YYLAST_ = 348;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 52;
  private static final int YYNTOKENS_ = 45;

  /* Unqualified %code blocks.  */
  /* "parser.y":15  */

  public static void main(String args[]) throws IOException {
    ParserLexer lexer = new ParserLexer(System.in);
    Parser parser = new Parser(lexer);
    if(parser.parse())
      System.out.println("---------------------\n Parser Completed Successfully!");
  }

  /* "parser.java":1311  */

}
/* "parser.y":160  */


class ParserLexer implements Parser.Lexer {
  InputStreamReader it;
  LexerAnalysis yylex;

  public ParserLexer(InputStream is){
    it = new InputStreamReader(is);
    yylex = new LexerAnalysis(it);
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
