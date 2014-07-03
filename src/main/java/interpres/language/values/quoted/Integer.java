package interpres.language.values.quoted;

import java.util.List;
import interpres.ast.AST;

public class Integer extends Quoted {
  public Integer(AST unquotedAST, java.lang.Integer representation) {
    super(unquotedAST, new interpres.language.values.Integer(representation));
  }

  public java.lang.Integer getRepresentation() {
    return ((interpres.language.values.Integer) this.getQuotedValue()).getRepresentation();
  }
}

