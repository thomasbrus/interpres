package interpres.language.definitions.interpres.list;

import java.util.Arrays;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.ast.LambdaExpression;

import interpres.language.definitions.Definition;
import interpres.language.DefinitionTable;

public class Reduce extends Definition {

  public Reduce() {
    super("interpres/list/reduce", new LambdaExpression((definitionTable, arguments) ->
      new interpres.language.invocations.interpres.list.Reduce(definitionTable, arguments).invoke()
    ));
  }

}

