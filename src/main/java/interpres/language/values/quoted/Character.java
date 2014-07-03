package interpres.language.values.quoted;

import java.util.List;
import interpres.ast.AST;

public class Character extends Quoted {
  public Character(AST unquotedAST, java.lang.Character representation) {
    super(unquotedAST, new interpres.language.values.Character(representation));
  }

  public java.lang.Character getRepresentation() {
    return ((interpres.language.values.Character) this.getQuotedValue()).getRepresentation();
  }
}

