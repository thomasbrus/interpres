package interpres.ast;

import java.util.List;
import java.util.ArrayList;


import interpres.language.DefinitionTable;

public class CharacterValue extends AST {
  private Character representation;

  public CharacterValue(Character representation) {
    this.representation = representation;
  }

  public AST evaluate(DefinitionTable definitionTable) {
    return ListExpression.buildFunctionCall("asm.loadc", new QuoteExpression(this))
      .evaluate(definitionTable);
  }

  public Character getRepresentation() {
    return this.representation;
  }
}

