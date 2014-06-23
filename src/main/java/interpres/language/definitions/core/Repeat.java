package interpres.language.definitions.core;

import interpres.ast.Symbol;
import interpres.ast.AST;

import interpres.language.definitions.Definition;

public class Repeat extends Definition {

  @SuppressWarnings("unchecked")
  public Repeat() {
    super("-", null, 0);
    // super("core.repeat", new EmptyInstructionSequenceLambda((definitionTable, arguments) -> {
    //   InstructionSequence repeatedInstructions = new InstructionSequence();

    //   PrintableInstructionSequence lengthIS = arguments.get(0).evaluate(definitionTable);
    //   EmptyInstructionSequenceAtom<Integer> lengthAtom = ((EmptyInstructionSequenceAtom<Integer>) lengthIS);

    //   PrintableInstructionSequence repeatableIS = arguments.get(1).evaluate(definitionTable);
    //   EmptyInstructionSequenceAtom<Object> repeatableAtom = ((EmptyInstructionSequenceAtom<Object>) repeatableIS);

    //   Integer length = lengthAtom.getValue();
    //   Object repeatable = repeatableAtom.getValue();

    //   for (int i = 0; i < lengthAtom.getValue(); i++) {
    //     repeatedInstructions.add(repeatable.toString());
    //   }

    //   return repeatedInstructions;
    // }), 0);
  }

}

