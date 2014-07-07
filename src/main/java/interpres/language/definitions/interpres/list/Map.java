package interpres.language.definitions.interpres.list;

import java.util.Arrays;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.ast.LambdaExpression;

import interpres.language.definitions.Definition;
import interpres.language.DefinitionTable;

public class Map extends Definition {

  /**
   * Constructs a new Map object.  
   */
  public Map() {
    super("interpres/list/map", new LambdaExpression((definitionTable, arguments) ->
      new interpres.language.invocations.interpres.list.Map(definitionTable, arguments).invoke()
    ));
  }

}

