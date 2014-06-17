package interpres.ast;

import java.util.Arrays;
import java.util.List;

import interpres.DefinitionTable;

public class QuotedExpression extends AST {
  private AST expression;

  public QuotedExpression(AST expression) {
    this.expression = expression;
  }

  public AST evaluate(DefinitionTable definitionTable) {
    return (AST) (new ListExpression(
      Arrays.asList(new Symbol("quote"), this.expression)
    ).evaluate(definitionTable));
  }

  public String toString() {
    return this.expression.toString();
  }
}

