# Make file to run and 

JFLEX  = /opt/homebrew/Cellar/jflex/1.8.2_1 
BYACCJ = ../../../byacc/yacc -J
JAVAC  = javac
SHELL  = /bin/zsh

# targets:

all:
	clear
	jflex lexer.l
	bison parser.y -L java
	javac *.java

clean:
	rm parser.java Yylex.java *.class