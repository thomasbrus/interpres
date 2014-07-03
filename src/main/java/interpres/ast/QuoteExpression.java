package interpres.ast;

import java.util.Arrays;
import java.util.List;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class QuoteExpression extends AST {
  private AST expression;

  public QuoteExpression(AST expression) {
    this.expression = expression;
  }

  public Value evaluate(DefinitionTable definitionTable) {
    return ListExpression.buildFunctionCall("core.quote", this.expression)
      .evaluate(definitionTable);
  }

  public AST getExpression() {
    return this.expression;
  }

  public Value quote() {
    return this.expression.quote();
  }
}
