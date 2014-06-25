package interpres.language.definitions.core.list;

import java.util.Arrays;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.ast.VirtualExpression;

import interpres.language.definitions.Definition;
import interpres.language.DefinitionTable;

import interpres.language.values.Value;
import interpres.language.values.Lambda;
import interpres.language.values.List;

public class Map extends Definition {

  public Map() {
    super("core.list.map", new Lambda((definitionTable, arguments) -> {
      java.util.List<Value> mappedItems = new ArrayList<Value>();

      Lambda lambdaValue = (Lambda) arguments.get(0).evaluate(definitionTable);
      List listValue = (List) arguments.get(1).evaluate(definitionTable);

      for (Value item : listValue.getItems()) {
        java.util.List<AST> mapableItem = Arrays.asList(new VirtualExpression(item));
        Value mappedItem = lambdaValue.getFunction().apply(definitionTable, mapableItem);
        mappedItems.add(mappedItem);
      }

      return new List(mappedItems);
    }));
  }

}

