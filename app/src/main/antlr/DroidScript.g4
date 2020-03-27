grammar DroidScript;

module: expressions+=expression* EOF;

expression: atom | list;

list: '(' values+=expression* ')';

atom: symbol | stringLiteral | boolLiteral | intLiteral | floatLiteral | nilLiteral;

symbol: VALID_SYMBOL_START VALID_SYMBOL_REST*;
stringLiteral: STRING_LITERAL;
boolLiteral: boolTrue | boolFalse;
boolFalse: 'false';
boolTrue: 'true';
intLiteral: SIGN?DIGIT+;
floatLiteral: SIGN?(('.'DIGIT+)|(DIGIT+'.')|(DIGIT+'.'DIGIT+));
nilLiteral: 'nil';

STRING_LITERAL:  STRING_QUOTE ( ESCAPES | ~('\'' | '\\' | '\n' | '\r') )* STRING_QUOTE;
fragment STRING_QUOTE: '\'' | '"';
DIGIT: [0-9];
SIGN: '+' | '-';

VALID_SYMBOL_START: ~([0-9]|' '|'\''|'"');
VALID_SYMBOL_REST: ~('('|')'|' '|'\''|'"');

WS: [ \n\t\r,]+ -> skip;

ESCAPES: '\\n' | '\\t' | '\\r' | '\\\'' | '\\"' | '\\\\';