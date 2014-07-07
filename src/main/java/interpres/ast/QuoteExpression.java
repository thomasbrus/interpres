package interpres.ast;

import java.util.Arrays;
import java.util.List;

import interpres.language.DefinitionTable;

public class QuoteExpression extends AST {
  private AST expression;

  /**
   * Constructs a new QuoteExpression.
   *
   * @param expression the expression coressponding with this QuoteExpression
   */
  public QuoteExpression(AST expression) {
    this.expression = expression;
  }

  /**
   * Generates an AST for this QuoteExpression.
   *
   * @param definitionTable the definition table used while evaluating the object
   */
  public AST evaluate(DefinitionTable definitionTable) {
    return this.getExpression();
  }

  /**
   * Returnes the actual value of this QuoteExpression  
   *
   * @return AST of this QuoteExpression
   */
  public AST getExpression() {
    return this.expression;
  }

  /**
   * Returns the instructions corresponding with this object.
   *
   * @return List of Strings containing the instructions belonging to this object
   */
  public List<String> instructionSequence() {
    return this.expression.instructionSequence();
  }
}

