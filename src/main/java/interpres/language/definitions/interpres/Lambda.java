package interpres.language.definitions.interpres;

import interpres.language.definitions.Definition;

public class Lambda extends Definition {

  /**
   * Constructs a new Lambda object.   
   */
  public Lambda() {
    super("interpres/lambda", new interpres.ast.LambdaExpression((definitionTable, arguments) ->
      new interpres.language.invocations.interpres.Lambda(definitionTable, arguments).invoke()
    ));
  }

}

