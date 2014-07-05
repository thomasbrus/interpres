package interpres.ast;

import java.util.Arrays;
import java.util.List;

import interpres.AsInstructionSequence;
import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class QuoteExpression extends AST {
  private AST expression;

  public QuoteExpression(AST expression) {
    this.expression = expression;
  }

  public AsInstructionSequence evaluate(DefinitionTable definitionTable) {
    return this;
  }

  public AST getExpression() {
    return this.expression;
  }

  // public Value unquote(DefinitionTable definitionTable) {
  //   return this.evaluate(definitionTable);
  // }
}

