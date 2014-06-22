package interpres.ast;

import java.util.Arrays;
import java.util.List;

import interpres.definitions.DefinitionTable;
import interpres.instructions.PrintableInstructionSequence;
import interpres.instructions.InstructionSequence;

public class QuotedExpression extends AST {
  private AST expression;

  public QuotedExpression(AST expression) {
    this.expression = expression;
  }

  public PrintableInstructionSequence evaluate(DefinitionTable definitionTable) {
    return new ListExpression(
      Arrays.asList(new Symbol("core.quote"), this.expression)
    ).evaluate(definitionTable);
  }

  public AST quote() {
    return this.expression;
  }

  public PrintableInstructionSequence unquote(DefinitionTable definitionTable) {
    return this.expression.evaluate(definitionTable);
  }
}

