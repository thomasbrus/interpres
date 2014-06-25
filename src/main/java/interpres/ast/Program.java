package interpres.ast;

import java.util.List;
import java.util.ArrayList;

import interpres.language.DefinitionTable;

import interpres.language.values.Value;
import interpres.language.values.String;

public class Program extends AST {
  private List<AST> expressions;

  public Program(List<AST> expressions) {
    this.expressions = expressions;
  }

  public Value evaluate(DefinitionTable definitionTable) {
    return ListExpression.buildFunctionCall("core.list", this.expressions)
      .evaluate(definitionTable);
  }
}

