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
      return new interpres.language.invocations.core.list.Map(definitionTable, arguments).invoke();
    }));
  }

}

