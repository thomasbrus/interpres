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

  AT = '@';
  PERCENT = '%';

  PROGRAM;
  LIST;
  STRING;
  SYMBOL;
  QUOTED;
  UNQUOTED;
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


expression: list | literal | quoted_expression | unquoted_expression;

list: LPAREN expression* RPAREN -> ^(LIST expression*);

literal: string -> ^(STRING string) | symbol -> ^(SYMBOL symbol);

string: String;
symbol: Symbol;

quoted_expression: AT expression -> ^(QUOTED expression);

unquoted_expression: PERCENT expression -> ^(UNQUOTED expression);

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

