package interpres.language.values.quoted;

import interpres.ast.AST;
import interpres.language.values.Value;

public class List extends Quoted {
  public List(AST unquotedAST, java.util.List<Value> items) {
    super(unquotedAST, new interpres.language.values.List(items));
  }

  public java.util.List<Value> getItems() {
    return ((interpres.language.values.List) this.getQuotedValue()).getItems();
  }
}

