package interpres.ast;

import java.util.Arrays;
import java.util.List;

import interpres.DefinitionTable;

public class QuotedExpression extends AST {
  private AST expression;

  public QuotedExpression(AST expression) {
    this.expression = expression;
  }

  public Object evaluate(DefinitionTable definitionTable) {
    return new ListExpression(
      Arrays.asList(new Symbol("quote"), this.expression)
    ).evaluate(definitionTable);
  }

  public String toString() {
    return this.expression.toString();
  }
}

