package interpres.language.values.quoted;

import java.util.List;
import interpres.ast.AST;

public class Character extends interpres.language.values.Character implements Unquotable {
  private AST characterAST;

  public Character(AST characterAST, java.lang.Character representation) {
    super(representation);
    this.characterAST = characterAST;
  }

  public AST getUnquotedAST() {
    return this.characterAST;
  }
}

