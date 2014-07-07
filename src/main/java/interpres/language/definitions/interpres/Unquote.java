package interpres.language.definitions.interpres;

import interpres.ast.AST;
import interpres.ast.UnquoteExpression;
import interpres.ast.LambdaExpression;

import interpres.language.definitions.Definition;

public class Unquote extends Definition {

  /**
   * Constructs a new Unquote object.
   * Creates a new UnquoteExpression based on the given argument.
   */
  public Unquote() {
    super("interpres/unquote", new LambdaExpression((definitionTable, arguments) -> {
      return new UnquoteExpression(arguments.get(0)).evaluate(definitionTable);
    }));
  }

}

