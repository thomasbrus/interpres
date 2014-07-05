package interpres.language.definitions.core;

import interpres.ast.AST;
import interpres.ast.UnquoteExpression;
import interpres.ast.LambdaExpression;

import interpres.language.definitions.Definition;

public class Unquote extends Definition {

  public Unquote() {
    super("core.unquote", new LambdaExpression((definitionTable, arguments) -> {
      return new UnquoteExpression(arguments.get(0)).evaluate(definitionTable);
    }, 1));
  }

}

