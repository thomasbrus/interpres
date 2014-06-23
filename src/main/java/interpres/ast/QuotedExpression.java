package interpres.ast;

import java.util.Arrays;
import java.util.List;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class QuotedExpression extends AST {
  private AST expression;

  public QuotedExpression(AST expression) {
    this.expression = expression;
  }

  public Value evaluate(DefinitionTable definitionTable) {
    return new ListExpression(
      Arrays.asList(new Symbol("core.quote"), this.expression)
    ).evaluate(definitionTable);
  }

  public AST quote() {
    return this.expression;
  }

  public Value unquote(DefinitionTable definitionTable) {
    return this.expression.evaluate(definitionTable);
  }
}

