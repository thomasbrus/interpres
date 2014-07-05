package interpres.ast;

import java.util.List;

import interpres.AsInstructionSequence;
import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class UnquoteExpression extends AST {
  private AST expression;

  public UnquoteExpression(AST expression) {
    this.expression = expression;
  }

  public AsInstructionSequence evaluate(DefinitionTable definitionTable) {
    AsInstructionSequence valueOrAST = this.expression.evaluate(definitionTable);

    if (!(valueOrAST instanceof AST))
      throw new UnsupportedOperationException("Unquoting is not supported for " + valueOrAST);

    return ((AST) valueOrAST).evaluate(definitionTable);
  }

  public Value getValue() {
    return this.expression.getValue();
  }
}

