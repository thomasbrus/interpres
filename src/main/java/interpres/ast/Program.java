package interpres.ast;

import java.util.List;
import java.util.stream.*;

import interpres.DefinitionTable;

public class Program extends AST {
  private List<AST> expressions;

  public Program(List<AST> expressions) {
    this.expressions = expressions;
  }

  public List<Object> evaluate(DefinitionTable definitionTable) {
    return this.expressions.stream().map((ast) ->
      ast.evaluate(definitionTable)
    ).collect(Collectors.toList());
  }

  public String toString() {
    return this.expressions.toString();
  }
}

