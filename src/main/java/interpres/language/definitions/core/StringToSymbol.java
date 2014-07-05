package interpres.language.definitions.core;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.ast.Symbol;
import interpres.ast.StringValue;
import interpres.ast.LambdaExpression;

import interpres.language.definitions.Definition;

public class StringToSymbol extends Definition {

  public StringToSymbol() {
    super("core.string-to-symbol", new LambdaExpression((definitionTable, arguments) -> {
      StringValue stringValue = (StringValue) arguments.get(0).evaluate(definitionTable);
      return new Symbol(stringValue.getLiteral());
    }));
  }

}

