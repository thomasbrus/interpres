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

program: expressions -> ^(LIST expressions);

expressions: expression*;

expression: sexp | list | atom;

sexp: LPAREN sexp_function_name sexp_argument* RPAREN -> ^(SEXPR sexp_function_name sexp_argument*);

sexp_function_name: expression;

sexp_argument: expression;

list: LBRACKET list_item* RBRACKET -> ^(LIST list_item*);

list_item: expression;

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

