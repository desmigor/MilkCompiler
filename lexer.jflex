import java.util.*; 
%% 
%class lexer
%standalone 
%line 
%column 
Numbers = \d+\.?\d* 

%{ 
  List<String> numbers = new ArrayList(); 
%}

%eof{ 
  System.out.print("Numbers: "); 
  for(int i=0;i<numbers.size();i++){ 
    if(i==numbers.size()-1) 
    System.out.print(numbers.get(i)); 
    else 
    System.out.print(numbers.get(i)+", "); 
  } 
%eof}

%% 
{Numbers} {numbers.add(yytext());} 
\n { /* Do Nothing */} 
. { /* Do Nothing */}

