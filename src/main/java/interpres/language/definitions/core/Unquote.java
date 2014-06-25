package interpres.language.definitions.core;

import java.util.Arrays;

import interpres.ast.AST;

import interpres.language.definitions.Definition;
import interpres.language.values.Lambda;

public class Unquote extends Definition {

  public Unquote() {
    super("core.unquote", new Lambda((definitionTable, arguments) -> {
      AST unquotable = arguments.get(0);
      return unquotable.unquote(definitionTable);
    }));
  }

}

