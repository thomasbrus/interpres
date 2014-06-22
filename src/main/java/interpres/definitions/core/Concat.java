package interpres.definitions.core;

import java.util.function.BiFunction;
import java.util.List;

import interpres.ast.AST;
import interpres.definitions.Definition;

import interpres.instructions.InstructionSequence;
import interpres.instructions.EmptyInstructionSequenceLambda;

public class Concat extends Definition {

  public Concat() {
    super("core.concat", new EmptyInstructionSequenceLambda((definitionTable, arguments) -> {
      InstructionSequence instructions = new InstructionSequence();

      for (AST argument : arguments) {
        for (String instruction : argument.evaluate(definitionTable)) {
          instructions.add(instruction);
        }
      }

      return instructions;
    }), 0);
  }

}

