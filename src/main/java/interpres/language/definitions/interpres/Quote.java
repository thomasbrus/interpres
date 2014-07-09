package interpres.language.definitions.interpres;

import java.util.Arrays;

import interpres.ast.AST;
import interpres.ast.QuoteExpression;
import interpres.ast.LambdaExpression;

import interpres.language.definitions.Definition;

public class Quote extends Definition {

  public Quote() {
    super("interpres/quote", new LambdaExpression((definitionTable, arguments) -> {
      return new QuoteExpression(arguments.get(0)).evaluate(definitionTable);
    }));
  }

}

