package interpres.language.values.quoted;

import interpres.ast.AST;
import interpres.language.values.Value;

public class List extends interpres.language.values.List implements Unquotable {
  private AST listAST;

  public List(AST listAST, java.util.List<Value> items) {
    super(items);
    this.listAST = listAST;
  }

  public AST getUnquotedAST() {
    return this.listAST;
  }
}

