package interpres.language.definitions.core;

import java.util.ArrayList;

import interpres.ast.Symbol;
import interpres.ast.AST;

import interpres.language.definitions.Definition;

import interpres.language.values.Value;
import interpres.language.values.Lambda;
import interpres.language.values.Integer;
import interpres.language.values.String;
import interpres.language.values.List;

public class Repeat extends Definition {

  public Repeat() {
    super("core.repeat", new Lambda((definitionTable, arguments) -> {
      Object repeatable = null;
      java.util.List<Object> repeatedItems = new ArrayList<Object>();

      Integer lengthValue = (Integer) arguments.get(0).evaluate(definitionTable);
      Value repeatableValue = arguments.get(1).evaluate(definitionTable);

      if (repeatableValue instanceof String) {
        repeatable = ((String) repeatableValue).getLiteral();
      } else if (repeatableValue instanceof Integer) {
        repeatable = ((Integer) repeatableValue).getValue();
      } else if (repeatableValue instanceof List) {
        repeatable = ((List) repeatableValue).getItems();
      }

      for (int i = 0; i < lengthValue.getValue() && repeatable instanceof Object; i++) {
        repeatedItems.add(repeatable);
      }

      return new interpres.language.values.List(repeatedItems);
    }), 0);
  }

}

