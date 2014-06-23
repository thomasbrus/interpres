package interpres.language.definitions.core;

import interpres.ast.AST;
import interpres.ast.QuotedExpression;

import interpres.language.definitions.Definition;

public class Unquote extends Definition {

  public Unquote() {
    super("-", null, 0);
    // super("core.unquote", new EmptyInstructionSequenceLambda((definitionTable, arguments) -> {
    //   Object unquotedObject = arguments.get(0).unquote(definitionTable);
    //   return new EmptyInstructionSequenceAtom<Object>(unquotedObject);
    // }), 0);
  }

}

