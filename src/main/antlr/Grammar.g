grammar Grammar;

options {
  k = 1;
  language = Java;
  output = AST;
}

tokens {
  LPAREN = '(';
  RPAREN = ')';

  LBRACKET = '[';
  RBRACKET = ']';

  DOUBLE_QUOTE = '"';

  PROGRAM;
  SEXPR;
  LIST;
  STRING;
  INTEGER;
  REFERENCE;
}

@lexer::header {
  package interpres;
}

@header {
  package interpres;
}

parse: program EOF -> program;

program: expressions -> ^(LIST expressions);

expressions: (expression)*;

expression: sexp | list | atom;

sexp: LPAREN expression+ RPAREN -> ^(SEXPR expression+);

list: LBRACKET expression* RBRACKET -> ^(LIST expression*);

atom: string | reference | integer;

string: DOUBLE_QUOTE except_double_quotes DOUBLE_QUOTE -> ^(STRING except_double_quotes*);
integer: NUMBER -> ^(INTEGER NUMBER);
reference: actual_reference -> ^(REFERENCE actual_reference);

except_double_quotes: ~(DOUBLE_QUOTE)*;
actual_reference: (IDENTIFIER);

IDENTIFIER: (LETTER | SPECIAL) (LETTER | DIGIT | SPECIAL)*;
NUMBER: DIGIT+;

COMMENT: ';' .* '\n' { $channel=HIDDEN; };
WS:   (' ' | '\t' | '\f' | '\r' | '\n')+ { $channel=HIDDEN; };

fragment DIGIT: ('0'..'9');
fragment LOWER: ('a'..'z');
fragment UPPER: ('A'..'Z');
fragment SPECIAL: '+' | '-' | '*' | '/' | '=' | '>' | '<';
fragment LETTER: LOWER | UPPER;

