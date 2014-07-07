package interpres.language.definitions.core;

import java.util.Collections;

import interpres.ast.AST;
import interpres.ast.LambdaExpression;
import interpres.ast.ListExpression;
import interpres.ast.Symbol;

import interpres.language.definitions.Definition;

public class Redefine extends Definition {

  public Redefine() {
    super("core.redefine", new LambdaExpression((definitionTable, arguments) -> {
      Symbol symbol = (Symbol) arguments.get(0).evaluate(definitionTable);
      AST value = arguments.get(1).evaluate(definitionTable);
      definitionTable.redefine(symbol.getName(), value);
      return new ListExpression(Collections.emptyList());
    }));
  }

}
