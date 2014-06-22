package interpres.definitions.core;

import interpres.ast.Symbol;
import interpres.definitions.Definition;

import interpres.instructions.EmptyInstructionSequenceLambda;
import interpres.instructions.EmptyInstructionSequenceAtom;

public class Length extends Definition {

  public Length() {
    super("core.length", new EmptyInstructionSequenceLambda((definitionTable, arguments) -> {
      Integer length = arguments.get(0).evaluate(definitionTable).length();
      return new EmptyInstructionSequenceAtom<Integer>(length);
    }), 0);
  }

}

