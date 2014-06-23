package interpres.language.definitions.core;

import java.util.Arrays;

import interpres.ast.Symbol;
import interpres.ast.ListExpression;
import interpres.language.definitions.Definition;

public class Length extends Definition {

  public Length() {
    super("-", null, 0);
    // super("core.length", new EmptyInstructionSequenceLambda((definitionTable, arguments) -> {
    //   Integer length = arguments.get(0).evaluate(definitionTable).length();
    //   return new ListExpression(
    //     Arrays.asList(new Symbol("core.quote"), new Symbol(length.toString()))
    //   ).evaluate(definitionTable);
    // }), 0);
  }

}

