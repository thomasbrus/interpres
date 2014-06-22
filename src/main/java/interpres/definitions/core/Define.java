package interpres.definitions.core;

import interpres.ast.Symbol;
import interpres.definitions.Definition;

import interpres.instructions.EmptyInstructionSequence;
import interpres.instructions.EmptyInstructionSequenceLambda;
import interpres.instructions.PrintableInstructionSequence;

public class Define extends Definition {

  public Define() {
    super("core.define", new EmptyInstructionSequenceLambda((definitionTable, arguments) -> {
      Symbol symbol = (Symbol) arguments.get(0);
      PrintableInstructionSequence definition = arguments.get(1).evaluate(definitionTable);
      definitionTable.define(symbol.getName(), definition);

      return new EmptyInstructionSequence();
    }), 0);
  }

}

