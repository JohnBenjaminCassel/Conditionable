grammar ConditionableCore;


orclause : andclause ('||' andclause)*;	

andclause : notclause ('&&' notclause)*; 

notclause : '!' notclause | parenclause;

parenclause : '(' orclause ')' | condition 
	| 'True' | 'False'; 

condition  
	: 'cond' conditionalvariable STRING  
	'[' (value (',' value)* )? ']';

conditionalvariable  : VARIABLE ;

value : var  | constant ;	

constant : STRING ;

var : VARIABLE ;

VARIABLE :'$' ('A'..'Z'|'a'..'z'|'0'..'9')+;

STRING : ('A'..'Z'|'a'..'z'|'0'..'9'|'.'|'>'|'<')+;

WHITESPACE :	(' '|'\t'|'\r'|'\n') {$channel=HIDDEN; };

