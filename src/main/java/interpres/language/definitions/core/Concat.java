package interpres.language.definitions.core;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.language.definitions.Definition;
import interpres.language.values.Lambda;

public class Concat extends Definition {

  public Concat() {
    super("core.concat", new Lambda((definitionTable, arguments) -> {
      List<String> instructions = new ArrayList<String>();

      for (AST argument : arguments) {
        for (String instruction : argument.evaluate(definitionTable)) {
          instructions.add(instruction);
        }
      }

      return new interpres.language.values.List(instructions);
    }), 0);
  }

}

