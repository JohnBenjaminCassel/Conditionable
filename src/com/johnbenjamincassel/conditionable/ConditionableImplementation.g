
grammar ConditionableImplementation;
@header {
	package com.johnbenjamincassel.conditionable;  
}

@members {
	public static AbstractExpression parseExpression(String expression) throws RecognitionException {
		ConditionableImplementationLexer lexer
			= new ConditionableImplementationLexer(new ANTLRStringStream(expression));
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(lexer);
		ConditionableImplementationParser parser
			= new ConditionableImplementationParser(tokens);
		return parser.orclause();
	}

}

orclause returns [AbstractExpression ae]: 
	c1=andclause { $ae = $c1.ae; } 
	('||' c2=andclause {  
		AbstractExpression ab_exp = $ae;
		$ae = new OrExpression(ab_exp, $c2.ae);
	})* ;	

andclause returns [AbstractExpression ae]
	: nc=notclause { $ae=$nc.ae; } 
	('&&' nc2=notclause { 
		AbstractExpression ab_exp = $ae;
		$ae = new AndExpression(ab_exp, $nc2.ae); })*; 

notclause returns [AbstractExpression ae]
	:	('!' nc=notclause { $ae = new NotExpression($nc.ae); } ) 
	| pc=parenclause { $ae=$pc.ae; };

parenclause returns [AbstractExpression ae] 
	: '(' c=orclause { $ae=$c.ae; } ')' 
	| con=condition { $ae = $con.ae; } 
	| 'True' { $ae = new TrueExpression(); }
	| 'False' { $ae = new FalseExpression(); };

condition returns [ConditionExpression ae] 
	: 'cond' cv=conditionalvariable STRING { $ae = new ConditionExpression($cv.cv, $STRING.text);} 
	'[' (v=value  { $ae.addArgument($v.v); } (','  v2=value { $ae.addArgument($v2.v); })* )? ']';

conditionalvariable returns [ConditionableVariable cv] :
	VARIABLE { $cv = new ConditionableVariable($VARIABLE.text); };

value returns [Value v]	: va=var { $v = $va.v; } | con=constant { $v = $con.c; } ;

constant returns [Constant c] : STRING { $c = new Constant($STRING.text); };

var returns [Variable v]: VARIABLE { $v = new Variable($VARIABLE.text, Object.class); };

VARIABLE :'$' ('A'..'Z'|'a'..'z'|'0'..'9')+;

STRING : ('A'..'Z'|'a'..'z'|'0'..'9'|'.'|'>'|'<')+;

WHITESPACE :	(' '|'\t'|'\r'|'\n') {$channel=HIDDEN; };
