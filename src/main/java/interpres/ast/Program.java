package interpres.ast;

import java.util.List;
import java.util.stream.*;

import interpres.definitions.DefinitionTable;
import interpres.instructions.PrintableInstructionSequence;
import interpres.instructions.InstructionSequence;

public class Program extends AST {
  private List<AST> expressions;

  public Program(List<AST> expressions) {
    this.expressions = expressions;
  }

  public PrintableInstructionSequence evaluate(DefinitionTable definitionTable) {
    // TODO: Utilize core.concat?
    InstructionSequence instructions = new InstructionSequence();

    for (AST expression : this.expressions) {
      for (String instruction : expression.evaluate(definitionTable)) {
        instructions.add(instruction);
      }
    }

    return instructions;
  }

  public List<AST> quote() {
    return this.expressions;
  }
}

