package interpres.language.values.quoted;

import interpres.ast.AST;

public class Symbol extends interpres.language.values.Symbol implements Unquotable {
  private AST symbolAST;

  public Symbol(AST symbolAST, java.lang.String intern) {
    super(intern);
    this.symbolAST = symbolAST;
  }

  public AST getUnquotedAST() {
    return this.symbolAST;
  }
}

