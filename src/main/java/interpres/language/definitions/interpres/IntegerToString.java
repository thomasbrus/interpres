package interpres.language.definitions.interpres;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.LambdaExpression;
import interpres.ast.IntegerValue;
import interpres.ast.StringValue;

import interpres.language.definitions.Definition;

public class IntegerToString extends Definition {

  /**
   * Constructs a new IntegerToString object.
   * Converts an integer to a string.
   */  
  public IntegerToString() {
    super("interpres/integer-to-string", new LambdaExpression((definitionTable, arguments) -> {
      IntegerValue integerValue = (IntegerValue) arguments.get(0).evaluate(definitionTable);
      return new StringValue(integerValue.getValue().toString());
    }));
  }

}

