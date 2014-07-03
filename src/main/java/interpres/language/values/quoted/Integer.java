package interpres.language.values.quoted;

import java.util.List;
import interpres.ast.AST;

public class Integer extends interpres.language.values.Integer implements Unquotable {
  private AST integerAST;

  public Integer(AST integerAST, java.lang.Integer representation) {
    super(representation);
    this.integerAST = integerAST;
  }

  public AST getUnquotedAST() {
    return this.integerAST;
  }
}

