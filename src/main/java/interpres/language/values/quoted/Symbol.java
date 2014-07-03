package interpres.language.values.quoted;

import interpres.ast.AST;

public class Symbol extends Quoted {
  private java.lang.String intern;

  public Symbol(AST unquotedAST, java.lang.String intern) {
    super(unquotedAST, new interpres.language.values.Symbol(intern));
  }

  public java.lang.String getIntern() {
    return ((interpres.language.values.Symbol) this.getQuotedValue()).getIntern();
  }
}

