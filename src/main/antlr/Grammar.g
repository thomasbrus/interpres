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




literal: string -> ^(STRING string) | symbol -> ^(SYMBOL symbol);

string: String;
symbol: Symbol;

// TODO: Add quoted expressions
atom: string -> ^(STRING string) | reference -> ^(REFERENCE reference);


// Lexer rules
// =============================================================================

String: '"' (~'"' | '\\' '"')* '"';

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

