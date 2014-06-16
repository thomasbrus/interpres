grammar Grammar;

options {
  k = 1;
  language = Java;
  output = AST;
}

tokens {
  LPAREN = '(';
  RPAREN = ')';

  DOUBLE_QUOTE = '"';

  PROGRAM;
  LIST;
  STRING;
  SYMBOL;
}

@lexer::header {
  package interpres;
}

@header {
  package interpres;
}

parse: program EOF -> program;

// Parser rules
// =============================================================================





symbol: Symbol;

// TODO: Add quoted expressions
atom: string -> ^(STRING string) | reference -> ^(REFERENCE reference);

string: QUOTED_VALUE;

// Lexer rules
// =============================================================================

QUOTED_VALUE: '"' (~'"')* '"';

Symbol: (Letter | Digit | Special)+;

COMMENT: ';' .* '\n' { $channel=HIDDEN; };
WS:(' ' | '\t' | '\f' | '\r' | '\n')+ { $channel=HIDDEN; };

// Protected lexer rules
// =============================================================================

fragment DIGIT: ('0'..'9');
fragment LOWER: ('a'..'z');
fragment UPPER: ('A'..'Z');
fragment SPECIAL: '+' | '-' | '*' | '/' | '=' | '>' | '<';
fragment LETTER: LOWER | UPPER;

