package interpres.language.definitions.core.integer;

import java.util.Arrays;

import interpres.ast.Symbol;
import interpres.ast.ListExpression;

import interpres.language.definitions.Definition;
import interpres.language.values.Lambda;
import interpres.language.values.Integer;

public class Sub extends Definition {

  public Sub() {
    super("core.integer.sub", new Lambda((definitionTable, arguments) -> {
      Integer firstInteger = (Integer) arguments.get(0).evaluate(definitionTable);
      Integer secondInteger = (Integer) arguments.get(1).evaluate(definitionTable);
      return new Integer(firstInteger.getValue() - secondInteger.getValue());
    }));
  }

}


