package interpres.ast;

import java.util.Arrays;

import interpres.language.DefinitionTable;

import interpres.language.values.Value;
import interpres.language.values.String;
import interpres.language.values.List;

public class Program extends AST {
  private java.util.List<AST> expressions;

  public Program(java.util.List<AST> expressions) {
    this.expressions = expressions;
  }

  public List evaluate(DefinitionTable definitionTable) {
    return (List) ListExpression.buildFunctionCall("core.list", this.expressions)
      .evaluate(definitionTable);
  }
}

