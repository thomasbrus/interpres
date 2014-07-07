package interpres.ast;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import interpres.language.DefinitionTable;

public class StringValue extends AST {
  private java.lang.String literal;

  /**
   * Constructs a new StringValue.
   *
   * @param literal the value of the string
   */
  public StringValue(java.lang.String literal) {
    this.literal = literal;
  }

  /**
   * Generates an AST for this StringValue.
   *
   * @param definitionTable the definition table used while evaluating the object
   */
  public AST evaluate(DefinitionTable definitionTable) {
    return ListExpression.buildFunctionCall("asm/loads", new QuoteExpression(this))
      .evaluate(definitionTable);
  }

  /**
   * Returnes the actual value of this StringValue.  
   *
   * @return the actual Character
   */
  public java.lang.String getLiteral() {
    return this.literal;
  }

  /**
   * Returns the instructions corresponding with this object.
   *
   * @return List of Strings containing the instructions belonging to this object
   */
  public List<String> instructionSequence() {
    return Arrays.asList(this.literal);
  }
}

