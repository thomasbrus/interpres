package interpres.language.definitions.interpres;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.ast.Symbol;
import interpres.ast.StringValue;
import interpres.ast.LambdaExpression;

import interpres.language.definitions.Definition;

public class StringToSymbol extends Definition {

  /**
   * Constructs a new StringToSymbol object.
   * Creates a Symbol out of a StringValue.
   */
  public StringToSymbol() {
    super("interpres/string-to-symbol", new LambdaExpression((definitionTable, arguments) -> {
      StringValue stringValue = (StringValue) arguments.get(0).evaluate(definitionTable);
      return new Symbol(stringValue.getLiteral());
    }));
  }

}

