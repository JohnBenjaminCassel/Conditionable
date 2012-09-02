// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g 2010-06-12 12:06:53

	package com.johnbenjamincassel.conditionable;  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ConditionableImplementationParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRING", "VARIABLE", "WHITESPACE", "'||'", "'&&'", "'!'", "'('", "')'", "'True'", "'False'", "'cond'", "'['", "','", "']'"
    };
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int VARIABLE=5;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int WHITESPACE=6;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;
    public static final int STRING=4;

    // delegates
    // delegators


        public ConditionableImplementationParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ConditionableImplementationParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ConditionableImplementationParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g"; }


    	public static AbstractExpression parseExpression(String expression) throws RecognitionException {
    		ConditionableImplementationLexer lexer
    			= new ConditionableImplementationLexer(new ANTLRStringStream(expression));
    		CommonTokenStream tokens = new CommonTokenStream();
    		tokens.setTokenSource(lexer);
    		ConditionableImplementationParser parser
    			= new ConditionableImplementationParser(tokens);
    		return parser.orclause();
    	}




    // $ANTLR start "orclause"
    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:20:1: orclause returns [AbstractExpression ae] : c1= andclause ( '||' c2= andclause )* ;
    public final AbstractExpression orclause() throws RecognitionException {
        AbstractExpression ae = null;

        AbstractExpression c1 = null;

        AbstractExpression c2 = null;


        try {
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:20:41: (c1= andclause ( '||' c2= andclause )* )
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:21:2: c1= andclause ( '||' c2= andclause )*
            {
            pushFollow(FOLLOW_andclause_in_orclause29);
            c1=andclause();

            state._fsp--;

             ae = c1; 
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:22:2: ( '||' c2= andclause )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==7) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:22:3: '||' c2= andclause
            	    {
            	    match(input,7,FOLLOW_7_in_orclause36); 
            	    pushFollow(FOLLOW_andclause_in_orclause40);
            	    c2=andclause();

            	    state._fsp--;

            	      
            	    		AbstractExpression ab_exp = ae;
            	    		ae = new OrExpression(ab_exp, c2);
            	    	

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ae;
    }
    // $ANTLR end "orclause"


    // $ANTLR start "andclause"
    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:27:1: andclause returns [AbstractExpression ae] : nc= notclause ( '&&' nc2= notclause )* ;
    public final AbstractExpression andclause() throws RecognitionException {
        AbstractExpression ae = null;

        AbstractExpression nc = null;

        AbstractExpression nc2 = null;


        try {
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:28:2: (nc= notclause ( '&&' nc2= notclause )* )
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:28:4: nc= notclause ( '&&' nc2= notclause )*
            {
            pushFollow(FOLLOW_notclause_in_andclause61);
            nc=notclause();

            state._fsp--;

             ae =nc; 
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:29:2: ( '&&' nc2= notclause )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==8) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:29:3: '&&' nc2= notclause
            	    {
            	    match(input,8,FOLLOW_8_in_andclause68); 
            	    pushFollow(FOLLOW_notclause_in_andclause72);
            	    nc2=notclause();

            	    state._fsp--;

            	     
            	    		AbstractExpression ab_exp = ae;
            	    		ae = new AndExpression(ab_exp, nc2); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ae;
    }
    // $ANTLR end "andclause"


    // $ANTLR start "notclause"
    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:33:1: notclause returns [AbstractExpression ae] : ( ( '!' nc= notclause ) | pc= parenclause );
    public final AbstractExpression notclause() throws RecognitionException {
        AbstractExpression ae = null;

        AbstractExpression nc = null;

        AbstractExpression pc = null;


        try {
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:34:2: ( ( '!' nc= notclause ) | pc= parenclause )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==9) ) {
                alt3=1;
            }
            else if ( (LA3_0==10||(LA3_0>=12 && LA3_0<=14)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:34:4: ( '!' nc= notclause )
                    {
                    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:34:4: ( '!' nc= notclause )
                    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:34:5: '!' nc= notclause
                    {
                    match(input,9,FOLLOW_9_in_notclause91); 
                    pushFollow(FOLLOW_notclause_in_notclause95);
                    nc=notclause();

                    state._fsp--;

                     ae = new NotExpression(nc); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:35:4: pc= parenclause
                    {
                    pushFollow(FOLLOW_parenclause_in_notclause107);
                    pc=parenclause();

                    state._fsp--;

                     ae =pc; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ae;
    }
    // $ANTLR end "notclause"


    // $ANTLR start "parenclause"
    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:37:1: parenclause returns [AbstractExpression ae] : ( '(' c= orclause ')' | con= condition | 'True' | 'False' );
    public final AbstractExpression parenclause() throws RecognitionException {
        AbstractExpression ae = null;

        AbstractExpression c = null;

        ConditionExpression con = null;


        try {
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:38:2: ( '(' c= orclause ')' | con= condition | 'True' | 'False' )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 10:
                {
                alt4=1;
                }
                break;
            case 14:
                {
                alt4=2;
                }
                break;
            case 12:
                {
                alt4=3;
                }
                break;
            case 13:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:38:4: '(' c= orclause ')'
                    {
                    match(input,10,FOLLOW_10_in_parenclause123); 
                    pushFollow(FOLLOW_orclause_in_parenclause127);
                    c=orclause();

                    state._fsp--;

                     ae =c; 
                    match(input,11,FOLLOW_11_in_parenclause131); 

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:39:4: con= condition
                    {
                    pushFollow(FOLLOW_condition_in_parenclause139);
                    con=condition();

                    state._fsp--;

                     ae = con; 

                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:40:4: 'True'
                    {
                    match(input,12,FOLLOW_12_in_parenclause147); 
                     ae = new TrueExpression(); 

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:41:4: 'False'
                    {
                    match(input,13,FOLLOW_13_in_parenclause154); 
                     ae = new FalseExpression(); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ae;
    }
    // $ANTLR end "parenclause"


    // $ANTLR start "condition"
    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:43:1: condition returns [ConditionExpression ae] : 'cond' cv= conditionalvariable STRING '[' (v= value ( ',' v2= value )* )? ']' ;
    public final ConditionExpression condition() throws RecognitionException {
        ConditionExpression ae = null;

        Token STRING1=null;
        ConditionableVariable cv = null;

        Value v = null;

        Value v2 = null;


        try {
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:44:2: ( 'cond' cv= conditionalvariable STRING '[' (v= value ( ',' v2= value )* )? ']' )
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:44:4: 'cond' cv= conditionalvariable STRING '[' (v= value ( ',' v2= value )* )? ']'
            {
            match(input,14,FOLLOW_14_in_condition170); 
            pushFollow(FOLLOW_conditionalvariable_in_condition174);
            cv=conditionalvariable();

            state._fsp--;

            STRING1=(Token)match(input,STRING,FOLLOW_STRING_in_condition176); 
             ae = new ConditionExpression(cv, (STRING1!=null?STRING1.getText():null));
            match(input,15,FOLLOW_15_in_condition182); 
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:45:6: (v= value ( ',' v2= value )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=STRING && LA6_0<=VARIABLE)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:45:7: v= value ( ',' v2= value )*
                    {
                    pushFollow(FOLLOW_value_in_condition187);
                    v=value();

                    state._fsp--;

                     ae.addArgument(v); 
                    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:45:43: ( ',' v2= value )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==16) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:45:44: ',' v2= value
                    	    {
                    	    match(input,16,FOLLOW_16_in_condition193); 
                    	    pushFollow(FOLLOW_value_in_condition198);
                    	    v2=value();

                    	    state._fsp--;

                    	     ae.addArgument(v2); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,17,FOLLOW_17_in_condition207); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ae;
    }
    // $ANTLR end "condition"


    // $ANTLR start "conditionalvariable"
    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:47:1: conditionalvariable returns [ConditionableVariable cv] : VARIABLE ;
    public final ConditionableVariable conditionalvariable() throws RecognitionException {
        ConditionableVariable cv = null;

        Token VARIABLE2=null;

        try {
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:47:56: ( VARIABLE )
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:48:2: VARIABLE
            {
            VARIABLE2=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_conditionalvariable220); 
             cv = new ConditionableVariable((VARIABLE2!=null?VARIABLE2.getText():null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return cv;
    }
    // $ANTLR end "conditionalvariable"


    // $ANTLR start "value"
    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:50:1: value returns [Value v] : (va= var | con= constant );
    public final Value value() throws RecognitionException {
        Value v = null;

        Variable va = null;

        Constant con = null;


        try {
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:50:25: (va= var | con= constant )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==VARIABLE) ) {
                alt7=1;
            }
            else if ( (LA7_0==STRING) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:50:27: va= var
                    {
                    pushFollow(FOLLOW_var_in_value236);
                    va=var();

                    state._fsp--;

                     v = va; 

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:50:52: con= constant
                    {
                    pushFollow(FOLLOW_constant_in_value244);
                    con=constant();

                    state._fsp--;

                     v = con; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return v;
    }
    // $ANTLR end "value"


    // $ANTLR start "constant"
    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:52:1: constant returns [Constant c] : STRING ;
    public final Constant constant() throws RecognitionException {
        Constant c = null;

        Token STRING3=null;

        try {
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:52:31: ( STRING )
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:52:33: STRING
            {
            STRING3=(Token)match(input,STRING,FOLLOW_STRING_in_constant259); 
             c = new Constant((STRING3!=null?STRING3.getText():null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return c;
    }
    // $ANTLR end "constant"


    // $ANTLR start "var"
    // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:54:1: var returns [Variable v] : VARIABLE ;
    public final Variable var() throws RecognitionException {
        Variable v = null;

        Token VARIABLE4=null;

        try {
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:54:25: ( VARIABLE )
            // C:\\Documents and Settings\\John\\workspace\\Conditionable\\src\\com\\johnbenjamincassel\\conditionable\\ConditionableImplementation.g:54:27: VARIABLE
            {
            VARIABLE4=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_var272); 
             v = new Variable((VARIABLE4!=null?VARIABLE4.getText():null), Object.class); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return v;
    }
    // $ANTLR end "var"

    // Delegated rules


 

    public static final BitSet FOLLOW_andclause_in_orclause29 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_7_in_orclause36 = new BitSet(new long[]{0x0000000000007600L});
    public static final BitSet FOLLOW_andclause_in_orclause40 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_notclause_in_andclause61 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_8_in_andclause68 = new BitSet(new long[]{0x0000000000007600L});
    public static final BitSet FOLLOW_notclause_in_andclause72 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_9_in_notclause91 = new BitSet(new long[]{0x0000000000007600L});
    public static final BitSet FOLLOW_notclause_in_notclause95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parenclause_in_notclause107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_parenclause123 = new BitSet(new long[]{0x0000000000007600L});
    public static final BitSet FOLLOW_orclause_in_parenclause127 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parenclause131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condition_in_parenclause139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_parenclause147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_parenclause154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_condition170 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_conditionalvariable_in_condition174 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_in_condition176 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_condition182 = new BitSet(new long[]{0x0000000000020030L});
    public static final BitSet FOLLOW_value_in_condition187 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_condition193 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_value_in_condition198 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_condition207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_conditionalvariable220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_value236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_value244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_constant259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_var272 = new BitSet(new long[]{0x0000000000000002L});

}