package interpres.language.definitions.interpres;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.ast.LambdaExpression;
import interpres.ast.CharacterValue;
import interpres.ast.StringValue;
import interpres.ast.ListExpression;

import interpres.language.definitions.Definition;

public class StringToList extends Definition {

  /**
   * Constructs a new StringToList object.
   * Converts a string to a ListExpression with characters.
   */
  public StringToList() {
    super("interpres/string-to-list", new LambdaExpression((definitionTable, arguments) -> {
      List<AST> characters = new ArrayList<AST>();
      StringValue string = (StringValue) arguments.get(0).evaluate(definitionTable);

      for (char c : string.getLiteral().toCharArray()) {
        characters.add(new CharacterValue(c));
      }

      return new ListExpression(characters);
    }));
  }

}

