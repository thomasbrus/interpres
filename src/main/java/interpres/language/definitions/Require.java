package interpres.language.definitions;

import java.nio.file.Path;
import java.nio.file.Paths;

import interpres.language.definitions.Definition;
import interpres.language.values.Lambda;

public class Require extends Definition {

  public Require(Path basePath) {
    super("require", new Lambda((definitionTable, arguments) ->
      new interpres.language.invocations.Require(definitionTable, arguments, basePath).invoke()
    ));
  }

  public Require(String basePath) {
    this(Paths.get(basePath));
  }

}

