package interpres.ast;

import java.util.List;
import java.util.ArrayList;

import interpres.AsInstructionSequence;
import interpres.language.DefinitionTable;

import interpres.language.values.Value;
import interpres.language.values.Character;

public class CharacterLiteral extends AST {
  private java.lang.Character representation;

  public CharacterLiteral(java.lang.Character representation) {
    this.representation = representation;
  }

  public AsInstructionSequence evaluate(DefinitionTable definitionTable) {
    return ListExpression.buildFunctionCall("asm.loadc", new QuoteExpression(this))
      .evaluate(definitionTable);
  }

  public java.lang.Character getRepresentation() {
    return this.representation;
  }
}

