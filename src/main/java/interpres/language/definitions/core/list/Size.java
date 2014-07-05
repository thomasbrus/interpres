package interpres.language.definitions.core.list;

import java.util.Arrays;

import interpres.ast.Symbol;
import interpres.ast.ListExpression;

import interpres.language.definitions.Definition;
import interpres.language.values.Lambda;
import interpres.language.values.List;

public class Size extends Definition {

  public Size() {
    super("core.list.size", new Lambda((definitionTable, arguments) -> {
      List listValue = (List) arguments.get(0).evaluate(definitionTable);
      // FIXME: Should use #getItems(), use (core.list.flatten) to get instruction size
      return new interpres.language.values.Integer(listValue.instructionSequence().size());
    }), 0);
  }

}

