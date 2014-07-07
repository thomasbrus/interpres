package interpres.language.definitions.interpres;

import java.util.ArrayList;

import interpres.ast.Symbol;
import interpres.ast.AST;
import interpres.ast.ListExpression;
import interpres.ast.LambdaExpression;

import interpres.language.definitions.Definition;

public class List extends Definition {

  /**
   * Constructs a new List object.
   * Creates a ListExpression based on the given (AST) arguments.
   */
  public List() {
    super("interpres/list", new LambdaExpression((definitionTable, arguments) -> {
      java.util.List<AST> listItems = new ArrayList<AST>();

      for (AST argument : arguments) {
        listItems.add((AST) argument.evaluate(definitionTable));
      }

      return new ListExpression(listItems);
    }));
  }

}

