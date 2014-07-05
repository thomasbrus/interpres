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
  INTEGER;
  CHARACTER;
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

@members {
  public void emitErrorMessage(String message) {
    throw new RuntimeException(message);
  }
}

parse: program EOF -> program;

// Parser rules
// =============================================================================

program: expression* -> ^(PROGRAM expression*);

expression: list | literal | quoted_expression | unquoted_expression;

list: LPAREN expression* RPAREN -> ^(LIST expression*);

literal
  : string -> ^(STRING string)
  | character -> ^(CHARACTER character)
  | integer -> ^(INTEGER integer)
  | symbol -> ^(SYMBOL symbol)
  ;

string: String;
character: Character;
integer: Integer;
symbol: Symbol;

quoted_expression: AT expression -> ^(QUOTED expression);
unquoted_expression: TILDE expression -> ^(UNQUOTED expression);

// Lexer rules
// =============================================================================

String: '"' (~'"' | '\\' '"')* '"';
Character: '\'' ~'\'' '\'';
Integer: Digit+;
Symbol:  (Letter | Special) (Letter | Special | Digit)*;

Comment: ';' .* '\n' { $channel=HIDDEN; };
Ws:(' ' | '\t' | '\f' | '\r' | '\n' | ',')+ { $channel=HIDDEN; };

// Protected lexer rules
// =============================================================================

fragment Digit: ('0'..'9');
fragment Letter: ('a'..'z') | ('A'..'Z');
fragment Special: '+' | '-' | '*' | '/' | '%' | '&' | '|' | '=' | '>' | '<' | '$' | '!' | '?' | '_' | '.' | ':';

