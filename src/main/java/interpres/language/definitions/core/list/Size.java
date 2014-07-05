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
      List listValue = (List) arguments.get(0).evaluate(definitionTable).getValue();
      // FIXME: Should use #getItems(), use (core.list.flatten) to get instruction size
      // FIXME: Would be better if there was a ast.IntegerLiteral
      return new interpres.ast.Symbol(Integer.toString(listValue.instructionSequence().size()));
    }), 0);
  }

}

