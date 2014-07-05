package interpres.ast;

import java.util.Arrays;
import interpres.language.DefinitionTable;

public class Program extends AST {
  private java.util.List<AST> expressions;

  public Program(java.util.List<AST> expressions) {
    this.expressions = expressions;
  }

  public ListExpression evaluate(DefinitionTable definitionTable) {
    return (ListExpression) ListExpression.buildFunctionCall("core.list", this.expressions)
      .evaluate(definitionTable);
  }
}

