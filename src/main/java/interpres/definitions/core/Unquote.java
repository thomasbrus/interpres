package interpres.definitions.core;

import interpres.ast.AST;
import interpres.ast.QuotedExpression;

import interpres.definitions.Definition;

import interpres.instructions.PrintableInstructionSequence;
import interpres.instructions.EmptyInstructionSequenceLambda;
import interpres.instructions.EmptyInstructionSequenceAtom;

public class Unquote extends Definition {

  public Unquote() {
    super("core.unquote", new EmptyInstructionSequenceLambda((definitionTable, arguments) -> {
      Object unquotedObject = arguments.get(0).unquote(definitionTable);
      return new EmptyInstructionSequenceAtom<Object>(unquotedObject);
    }), 0);
  }

}

