package interpres.ast;

import java.util.List;
import java.util.Arrays;

import interpres.language.DefinitionTable;

public class UnquoteExpression extends AST {
  private AST expression;

  /**
   * Constructs a new UnquoteExpression.
   *
   * @param expression the expression coressponding with this UnquoteExpression
   */
  public UnquoteExpression(AST expression) {
    this.expression = expression;
  }

  /**
   * Generates an AST for this UnquoteExpression.
   *
   * @param definitionTable the definition table used while evaluating the object
   */
  public AST evaluate(DefinitionTable definitionTable) {
    return this.expression.evaluate(definitionTable).evaluate(definitionTable);
  }

  /**
   * Returns the instructions corresponding with this object.
   *
   * @return List of Strings containing the instructions belonging to this object
   */
  public List<String> instructionSequence() {
    return Arrays.asList(this.expression.toString());
  }
}

