package interpres.ast;

import java.util.Arrays;

import interpres.AsBytecode;
import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class UnquoteExpression extends AST {
  private AST expression;

  public UnquoteExpression(AST expression) {
    this.expression = expression;
  }

  public AsBytecode evaluate(DefinitionTable definitionTable) {
    AsBytecode valueOrAST = this.expression.evaluate(definitionTable);

    if (!(valueOrAST instanceof AST))
      throw new UnsupportedOperationException("Unquoting is not supported for " + valueOrAST);

    return ((AST) valueOrAST).evaluate(definitionTable);
  }
}

