package interpres.ast;

import java.util.List;
import java.util.stream.*;

import interpres.DefinitionTable;
import interpres.PrintableBytecode;
import interpres.InstructionSequence;

public class Program extends AST {
  private List<AST> expressions;

  public Program(List<AST> expressions) {
    this.expressions = expressions;
  }

  public PrintableBytecode evaluate(DefinitionTable definitionTable) {
    InstructionSequence instructions = new InstructionSequence();

    for (AST expression : this.expressions) {
      for (String instruction : expression.evaluate(definitionTable)) {
        instructions.add(instruction);
      }
    }

    return instructions;
  }

  public String toString() {
    return this.expressions.toString();
  }
}

