package interpres.ast;

import java.util.List;
import java.util.Arrays;

import interpres.language.DefinitionTable;

public class CharacterValue extends AST {
  private Character representation;

  /**
   * Constructs a new CharacterValue.
   *
   * @param representation the value of the character
   */
  public CharacterValue(Character representation) {
    this.representation = representation;
  }

  /**
   * Generates an AST for this CharacterValue.
   *
   * @param definitionTable the definition table used while evaluating the object
   */
  public AST evaluate(DefinitionTable definitionTable) {
    return ListExpression.buildFunctionCall("asm/loadc", new QuoteExpression(this))
      .evaluate(definitionTable);
  }

  /**
   * Returnes the actual value of this CharacterValue.  
   *
   * @return the actual Character
   */
  public Character getRepresentation() {
    return this.representation;
  }

  /**
   * Returns the instructions corresponding with this object.
   *
   * @return List of Strings containing the instructions belonging to this object
   */
  public List<String> instructionSequence() {
    return Arrays.asList(this.representation.toString());
  }
}

