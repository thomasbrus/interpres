package interpres.language.definitions.core.list;

import java.util.Collections;

import interpres.ast.AST;
import interpres.language.definitions.Definition;

import interpres.language.values.Value;
import interpres.language.values.Lambda;
import interpres.language.values.List;

public class Reverse extends Definition {

  public Reverse() {
    super("core.list.reverse", new Lambda((definitionTable, arguments) -> {
      List reversableValue = (List) arguments.get(0).evaluate(definitionTable).getValue();
      // FIXME: Shouldn't modify original list (?)
      Collections.reverse(reversableValue.getItems());
      return reversableValue;
    }));
  }

}

