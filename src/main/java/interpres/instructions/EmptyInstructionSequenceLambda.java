package interpres.instructions;

import java.util.List;
import java.util.function.BiFunction;

import interpres.ast.AST;
import interpres.definitions.DefinitionTable;

public class EmptyInstructionSequenceLambda extends EmptyInstructionSequence {
  private BiFunction<DefinitionTable, List<AST>, PrintableInstructionSequence> fn;

  public EmptyInstructionSequenceLambda(BiFunction<DefinitionTable, List<AST>, PrintableInstructionSequence> fn) {
    this.fn = fn;
  }

  public PrintableInstructionSequence apply(DefinitionTable dt, List<AST> arguments) {
    return fn.apply(dt, arguments);
  }
}

