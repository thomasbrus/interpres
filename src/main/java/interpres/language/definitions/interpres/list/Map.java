package interpres.language.definitions.interpres.list;

import java.util.Arrays;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.ast.LambdaExpression;

import interpres.language.definitions.Definition;
import interpres.language.DefinitionTable;

public class Map extends Definition {

  public Map() {
    super("interpres/list/map", new LambdaExpression((definitionTable, arguments) ->
      new interpres.language.invocations.core.list.Map(definitionTable, arguments).invoke()
    ));
  }

}
