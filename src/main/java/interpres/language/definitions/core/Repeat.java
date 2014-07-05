package interpres.language.definitions.core;

import java.util.Collections;

import interpres.ast.Symbol;
import interpres.ast.AST;
import interpres.ast.ListExpression;

import interpres.language.definitions.Definition;

import interpres.language.values.Value;
import interpres.language.values.Lambda;
import interpres.language.values.Integer;
import interpres.language.values.String;
import interpres.language.values.List;

public class Repeat extends Definition {

  public Repeat() {
    super("core.repeat", new Lambda((definitionTable, arguments) -> {
      Integer countValue = (Integer) arguments.get(0).evaluate(definitionTable).getValue();

      return ListExpression.buildFunctionCall(
        "core.list", Collections.nCopies(countValue.getRepresentation(), arguments.get(1))
      ).evaluate(definitionTable);
    }));
  }

}

