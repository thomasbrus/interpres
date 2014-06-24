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
      java.util.List<Value> repeatedItems = new ArrayList<Value>();

      Integer lengthValue = (Integer) arguments.get(0).evaluate(definitionTable);
      Value repeatableValue = arguments.get(1).evaluate(definitionTable);

      for (int i = 0; i < lengthValue.getValue(); i++) {
        repeatedItems.add(repeatableValue);
      }

      return new interpres.language.values.List(repeatedItems);
    }), 0);
  }

}

