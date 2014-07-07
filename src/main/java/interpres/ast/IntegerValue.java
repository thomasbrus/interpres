package interpres.ast;

import java.util.List;
import java.util.Arrays;

import interpres.language.DefinitionTable;

public class IntegerValue extends AST {
  private Integer value;

  /**
   * Constructs a new IntegerValue.
   *
   * @param value the value of the integer
   */
  public IntegerValue(Integer value) {
    this.value = value;
  }

  /**
   * Generates an AST for this IntegerValue.
   *
   * @param definitionTable the definition table used while evaluating the object
   */
  public AST evaluate(DefinitionTable definitionTable) {
    return ListExpression.buildFunctionCall("asm/loadl", new QuoteExpression(this))
      .evaluate(definitionTable);
  }

  /**
   * Returnes the actual value of this IntegerValue.  
   *
   * @return the actual Integer
   */
  public Integer getValue() {
    return this.value;
  }

  /**
   * Returns the instructions corresponding with this object.
   *
   * @return List of Strings containing the instructions belonging to this object
   */
  public List<String> instructionSequence() {
    return Arrays.asList(this.value.toString());
  }
}

