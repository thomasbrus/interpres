package interpres.language.definitions.interpres;

import interpres.ast.LambdaExpression;
import interpres.language.definitions.Definition;

public class Let extends Definition {

  /**
   * Constructs a new Let object.
   */
  public Let() {
    super("interpres/let", new LambdaExpression((definitionTable, arguments) ->
      new interpres.language.invocations.interpres.Let(definitionTable, arguments).invoke()
    ));
  }

}

