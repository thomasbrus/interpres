package interpres.language.definitions.interpres;

import java.util.Collections;

import interpres.ast.AST;
import interpres.ast.LambdaExpression;
import interpres.ast.ListExpression;
import interpres.ast.Symbol;

import interpres.language.definitions.Definition;

public class Bind extends Definition {

  /**
   * Constructs a new Bind object.
   * Binds an AST to a given Symbol.
   */
  public Bind() {
    super("interpres/bind", new LambdaExpression((definitionTable, arguments) -> {
      Symbol symbol = (Symbol) arguments.get(0).evaluate(definitionTable);
      AST value = arguments.get(1).evaluate(definitionTable);
      definitionTable.bind(symbol.getName(), value);
      return new ListExpression(Collections.emptyList());
    }));
  }

}

