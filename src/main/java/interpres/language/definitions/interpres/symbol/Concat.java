package interpres.language.definitions.interpres.symbol;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.ast.LambdaExpression;
import interpres.ast.Symbol;

import interpres.language.definitions.Definition;

public class Concat extends Definition {

  public Concat() {
    super("interpres/symbol/concat", new LambdaExpression((definitionTable, arguments) -> {
      List<String> symbolNames = new ArrayList<String>();

      for (AST argument : arguments) {
        Symbol concatenable = (Symbol) argument.evaluate(definitionTable);
        symbolNames.add(concatenable.getName());
      }

      return new Symbol(String.join("", symbolNames));
    }));
  }

}

