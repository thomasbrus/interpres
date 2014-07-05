package interpres.language.definitions.core;

import interpres.ast.AST;
import interpres.ast.UnquoteExpression;
import interpres.language.definitions.Definition;
import interpres.language.values.Lambda;

public class Unquote extends Definition {

  public Unquote() {
    super("core.unquote", new Lambda((definitionTable, arguments) -> {
      return new UnquoteExpression(arguments.get(0)).evaluate(definitionTable);
    }));
  }

}

