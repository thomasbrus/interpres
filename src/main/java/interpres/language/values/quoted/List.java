package interpres.language.values.quoted;

import interpres.ast.AST;
import interpres.language.values.Value;

public class List extends Quoted {
  public List(AST unquotedAST, interpres.language.values.List listValue) {
    super(unquotedAST, listValue);
  }

  public java.util.List<Value> getItems() {
    return ((interpres.language.values.List) this.getQuotedValue()).getItems();
  }
}

