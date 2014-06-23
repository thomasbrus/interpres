package interpres.ast;

import java.util.List;
import java.util.Arrays;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class Program extends AST {
  private List<AST> expressions;

  public Program(List<AST> expressions) {
    this.expressions = expressions;
  }

  public Value evaluate(DefinitionTable definitionTable) {
    return ListExpression.buildFunctionCall("core.concat", this.expressions).evaluate(definitionTable);
  }

  public List<AST> quote() {
    return this.expressions;
  }
}
