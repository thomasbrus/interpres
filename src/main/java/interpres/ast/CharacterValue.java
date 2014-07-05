package interpres.ast;

import java.util.List;
import java.util.Arrays;

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

  public List<String> instructionSequence() {
    return Arrays.asList(this.representation.toString());
  }
}

