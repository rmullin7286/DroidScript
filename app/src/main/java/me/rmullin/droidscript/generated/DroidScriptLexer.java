// Generated from C:/Users/Ryan/OneDrive/Source/DroidScript/app/src/main/antlr\DroidScript.g4 by ANTLR 4.7.2
package me.rmullin.droidscript.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DroidScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, STRING_LITERAL=6, DIGIT=7, SIGN=8, 
		VALID_SYMBOL_START=9, VALID_SYMBOL_REST=10, WS=11, ESCAPES=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "STRING_LITERAL", "STRING_QUOTE", 
			"DIGIT", "SIGN", "VALID_SYMBOL_START", "VALID_SYMBOL_REST", "WS", "ESCAPES"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'false'", "'true'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "STRING_LITERAL", "DIGIT", "SIGN", 
			"VALID_SYMBOL_START", "VALID_SYMBOL_REST", "WS", "ESCAPES"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public DroidScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DroidScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16W\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\7\7\62\n\7\f\7\16\7\65\13\7\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\6\rD\n\r\r\r\16\r"+
		"E\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16V\n\16\2\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\2\21\t\23\n\25\13\27\f"+
		"\31\r\33\16\3\2\t\6\2\f\f\17\17))^^\4\2$$))\3\2\62;\4\2--//\6\2\"\"$$"+
		"))\62;\5\2\"\"$$)+\5\2\13\f\17\17\"\"\2]\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\37"+
		"\3\2\2\2\7!\3\2\2\2\t\'\3\2\2\2\13,\3\2\2\2\r.\3\2\2\2\178\3\2\2\2\21"+
		":\3\2\2\2\23<\3\2\2\2\25>\3\2\2\2\27@\3\2\2\2\31C\3\2\2\2\33U\3\2\2\2"+
		"\35\36\7*\2\2\36\4\3\2\2\2\37 \7+\2\2 \6\3\2\2\2!\"\7h\2\2\"#\7c\2\2#"+
		"$\7n\2\2$%\7u\2\2%&\7g\2\2&\b\3\2\2\2\'(\7v\2\2()\7t\2\2)*\7w\2\2*+\7"+
		"g\2\2+\n\3\2\2\2,-\7\60\2\2-\f\3\2\2\2.\63\5\17\b\2/\62\5\33\16\2\60\62"+
		"\n\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3"+
		"\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\5\17\b\2\67\16\3\2\2\289\t\3"+
		"\2\29\20\3\2\2\2:;\t\4\2\2;\22\3\2\2\2<=\t\5\2\2=\24\3\2\2\2>?\n\6\2\2"+
		"?\26\3\2\2\2@A\n\7\2\2A\30\3\2\2\2BD\t\b\2\2CB\3\2\2\2DE\3\2\2\2EC\3\2"+
		"\2\2EF\3\2\2\2FG\3\2\2\2GH\b\r\2\2H\32\3\2\2\2IJ\7^\2\2JV\7p\2\2KL\7^"+
		"\2\2LV\7v\2\2MN\7^\2\2NV\7t\2\2OP\7^\2\2PV\7)\2\2QR\7^\2\2RV\7$\2\2ST"+
		"\7^\2\2TV\7^\2\2UI\3\2\2\2UK\3\2\2\2UM\3\2\2\2UO\3\2\2\2UQ\3\2\2\2US\3"+
		"\2\2\2V\34\3\2\2\2\7\2\61\63EU\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}