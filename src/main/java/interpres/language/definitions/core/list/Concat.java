package interpres.language.definitions.core.list;

import java.util.ArrayList;

import interpres.AsBytecode;

import interpres.ast.AST;
import interpres.language.definitions.Definition;

import interpres.language.values.Value;
import interpres.language.values.Lambda;
import interpres.language.values.List;

public class Concat extends Definition {

  public Concat() {
    super("core.list.concat", new Lambda((definitionTable, arguments) -> {
      java.util.List<AsBytecode> concatenatedItems = new ArrayList<AsBytecode>();

      for (AST argument : arguments) {
        List listValue = (List) argument.evaluate(definitionTable);
        concatenatedItems.addAll(listValue.getItems());
      }

      return new List(concatenatedItems);
    }));
  }

}

