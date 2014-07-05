package interpres.language.values;

import java.util.List;
import java.util.function.BiFunction;

import interpres.AsInstructionSequence;
import interpres.ast.AST;
import interpres.language.DefinitionTable;

public class Lambda extends Value {
  private BiFunction<DefinitionTable, List<AST>, AsInstructionSequence> function;

  public Lambda(BiFunction<DefinitionTable, List<AST>, AsInstructionSequence> function) {
    this.function = function;
  }

  public BiFunction<DefinitionTable, List<AST>, AsInstructionSequence> getFunction() {
    return this.function;
  }
}

