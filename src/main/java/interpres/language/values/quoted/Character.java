package interpres.language.values.quoted;

import java.util.List;
import interpres.ast.AST;

public class Character extends Quoted {
  public Character(AST unquotedAST, interpres.language.values.Character characterValue) {
    super(unquotedAST, characterValue);
  }

  public java.lang.Character getRepresentation() {
    return ((interpres.language.values.Character) this.getQuotedValue()).getRepresentation();
  }
}

