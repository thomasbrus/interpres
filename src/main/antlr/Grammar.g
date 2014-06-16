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
  REFERENCE;
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






// TODO: Add quoted expressions
atom: string -> ^(STRING string) | reference -> ^(REFERENCE reference);

string: QUOTED_VALUE;
reference: IDENTIFIER;

// Lexer rules
// =============================================================================

QUOTED_VALUE: '"' (~'"')* '"';

IDENTIFIER: (LETTER | DIGIT | SPECIAL)+;

COMMENT: ';' .* '\n' { $channel=HIDDEN; };
WS:(' ' | '\t' | '\f' | '\r' | '\n')+ { $channel=HIDDEN; };

// Protected lexer rules
// =============================================================================

fragment DIGIT: ('0'..'9');
fragment LOWER: ('a'..'z');
fragment UPPER: ('A'..'Z');
fragment SPECIAL: '+' | '-' | '*' | '/' | '=' | '>' | '<';
fragment LETTER: LOWER | UPPER;

