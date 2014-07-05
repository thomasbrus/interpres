package interpres.language.definitions.core;

import java.util.ArrayList;

import interpres.AsBytecode;

import interpres.ast.Symbol;
import interpres.ast.AST;

import interpres.language.definitions.Definition;
import interpres.language.values.Value;
import interpres.language.values.Lambda;

public class List extends Definition {

  public List() {
    super("core.list", new Lambda((definitionTable, arguments) -> {
      java.util.List<AsBytecode> listItems = new ArrayList<AsBytecode>();

      for (AST argument : arguments) {
        AsBytecode listItemValue = argument.evaluate(definitionTable);
        listItems.add(listItemValue);
      }

      return new interpres.language.values.List(listItems);
    }));
  }

}

