package interpres.language.definitions.core.integer;

import java.util.Arrays;

import interpres.ast.Symbol;
import interpres.ast.ListExpression;

import interpres.language.definitions.Definition;
import interpres.language.values.Lambda;
import interpres.language.values.Integer;

public class Subtract extends Definition {

  public Subtract() {
    super("core.integer.subtract", new Lambda((definitionTable, arguments) -> {
      Integer firstInteger = (Integer) arguments.get(0).evaluate(definitionTable).getValue();
      Integer secondInteger = (Integer) arguments.get(1).evaluate(definitionTable).getValue();
      int delta = firstInteger.getRepresentation() - secondInteger.getRepresentation();
      return new Symbol(java.lang.Integer.toString(delta));
    }));
  }

}


