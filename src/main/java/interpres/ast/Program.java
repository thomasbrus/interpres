package interpres.ast;

import java.util.Arrays;
import interpres.language.DefinitionTable;

public class Program extends AST {
  private java.util.List<AST> expressions;

  /**
   * Constructs a new Program
   *
   * @param expressions a list with ASTs that form the program
   */
  public Program(java.util.List<AST> expressions) {
    this.expressions = expressions;
  }

  /**
   * Generates an AST for this Program
   *
   * @param definitionTable the definition table used while evaluating the object
   */
  public ListExpression evaluate(DefinitionTable definitionTable) {
    return (ListExpression) ListExpression.buildFunctionCall("interpres/list", this.expressions)
      .evaluate(definitionTable);
  }
}

