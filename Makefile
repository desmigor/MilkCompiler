#jflex lexer.jflex 
#javac lexer.java
#java milk milk_examples/basic.milk 

# only works with the Java extension of yacc: 
# byacc/j from http://troi.lincom-asg.com/~rjamison/byacc/

JFLEX  = /opt/homebrew/Cellar/jflex/1.8.2_1 
BYACCJ = ../../../byacc/yacc -J
JAVAC  = javac
SHELL  = /bin/zsh

# targets:

all: Parser.class

run: Parser.class
 java Parser

build: clean Parser.class

clean:
	rm -f *~ *.class *.java

Parser.class: Yylex.java Parser.java
 $(JAVAC) Parser.java

Yylex.java: lexer.flex
 $(JFLEX) flex.flex

Parser.java: parser.y
 $(BYACCJ) parser.y
