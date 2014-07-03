package interpres.language.values.quoted;

import interpres.ast.AST;

public class String extends interpres.language.values.String implements Unquotable {
  private AST stringAST;

  public String(AST stringAST, java.lang.String literal) {
    super(literal);
    this.stringAST = stringAST;
  }

  public AST getUnquotedAST() {
    return this.stringAST;
  }
}

