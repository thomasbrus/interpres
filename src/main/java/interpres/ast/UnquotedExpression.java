package interpres.ast;

import java.util.Arrays;

import interpres.definitions.DefinitionTable;
import interpres.instructions.PrintableInstructionSequence;
import interpres.instructions.InstructionSequence;

public class UnquotedExpression extends AST {
  private AST expression;

  public UnquotedExpression(AST expression) {
    this.expression = expression;
  }

  public PrintableInstructionSequence evaluate(DefinitionTable definitionTable) {
    return new ListExpression(
      Arrays.asList(new Symbol("core.unquote"), this.expression)
    ).evaluate(definitionTable);
  }

  public AST quote() {
    return this.expression;
  }
}

