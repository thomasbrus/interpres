package interpres.language.values.quoted;

import java.util.List;
import interpres.ast.AST;

public class Integer extends Quoted {
  public Integer(AST unquotedAST, interpres.language.values.Integer integerValue) {
    super(unquotedAST, integerValue);
  }

  public java.lang.Integer getRepresentation() {
    return ((interpres.language.values.Integer) this.getQuotedValue()).getRepresentation();
  }
}

