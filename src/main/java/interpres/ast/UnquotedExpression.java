package interpres.ast;

import java.util.Arrays;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class UnquotedExpression extends AST {
  private AST expression;

  public UnquotedExpression(AST expression) {
    this.expression = expression;
  }

  public Value evaluate(DefinitionTable definitionTable) {
    return ListExpression.buildFunctionCall("core.unquote", this.expression).evaluate(definitionTable);
  }

  public AST quote() {
    return this.expression;
  }
}

