package interpres.language.values.quoted;

import interpres.ast.AST;

public class Symbol extends Quoted {
  private java.lang.String intern;

  public Symbol(AST unquotedAST, interpres.language.values.Symbol symbolValue) {
    super(unquotedAST, symbolValue);
  }

  public java.lang.String getIntern() {
    return ((interpres.language.values.Symbol) this.getQuotedValue()).getIntern();
  }
}

