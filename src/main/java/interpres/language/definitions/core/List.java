package interpres.language.definitions.core;

import java.util.ArrayList;

import interpres.ast.Symbol;
import interpres.ast.AST;

import interpres.language.definitions.Definition;

import interpres.language.values.Value;
import interpres.language.values.Lambda;

public class List extends Definition {

  public List() {
    super("core.list", new Lambda((definitionTable, arguments) -> {
      java.util.List<Value> listItems = new ArrayList<Value>();

      for (AST argument : arguments) {
        Value listItemValue = argument.evaluate(definitionTable);
        listItems.add(listItemValue);
      }

      return new interpres.language.values.List(listItems);
    }));
  }

}

