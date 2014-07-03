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
  TILDE = '\~';

  PROGRAM;
  LIST;
  STRING;
  CHAR;
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

program: expression* -> ^(PROGRAM expression*);

expression: list | literal | quoted_expression | unquoted_expression;

list: LPAREN expression* RPAREN -> ^(LIST expression*);

literal: string -> ^(STRING string) | symbol -> ^(SYMBOL symbol) | character -> ^(CHAR character);

string: String;
symbol: Symbol;
character: Char;

quoted_expression: AT expression -> ^(QUOTED expression);

unquoted_expression: TILDE expression -> ^(UNQUOTED expression);

// Lexer rules
// =============================================================================

String: '"' (~'"' | '\\' '"')* '"';
Char:   '\'' ~'\'' '\'';

Symbol: (Letter | Digit | Special)+;

Comment: ';' .* '\n' { $channel=HIDDEN; };
Ws:(' ' | '\t' | '\f' | '\r' | '\n' | ',')+ { $channel=HIDDEN; };

// Protected lexer rules
// =============================================================================

fragment Digit: ('0'..'9');
fragment Lower: ('a'..'z');
fragment Upper: ('A'..'Z');
fragment Special: '+' | '-' | '*' | '/' | '%' | '&' | '|' | '=' | '>' | '<' | '$' | '!' | '?' | '_' | '.' | ':';
fragment Letter: Lower | Upper;
