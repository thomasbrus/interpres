package interpres.definitions.core;

import java.util.Arrays;
import java.util.List;

import interpres.ast.AST;
import interpres.definitions.Definition;

import interpres.instructions.EmptyInstructionSequenceLambda;
import interpres.instructions.InstructionSequenceAtom;

public class Quote extends Definition {

  public Quote() {
    super("core.quote", new EmptyInstructionSequenceLambda((definitionTable, arguments) -> {
      Object quotedObject = arguments.get(0).quote();
      List<String> instructions = Arrays.asList(quotedObject.toString());
      return new InstructionSequenceAtom<Object>(instructions, quotedObject);
    }), 0);
  }

}

