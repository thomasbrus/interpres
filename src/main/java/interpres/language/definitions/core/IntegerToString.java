package interpres.language.definitions.core;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;

import interpres.language.definitions.Definition;

import interpres.language.values.Lambda;
import interpres.language.values.Integer;
import interpres.language.values.String;

public class IntegerToString extends Definition {

  public IntegerToString() {
    super("core.integer-to-string", new Lambda((definitionTable, arguments) -> {
      Integer integerValue = (Integer) arguments.get(0).evaluate(definitionTable);
      return new String(integerValue.getValue().toString());
    }), 0);
  }

}

