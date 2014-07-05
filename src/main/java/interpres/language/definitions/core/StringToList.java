package interpres.language.definitions.core;

import java.util.List;
import java.util.ArrayList;



import interpres.ast.AST;
import interpres.ast.LambdaExpression;
import interpres.ast.CharacterValue;
import interpres.ast.StringValue;
import interpres.ast.ListExpression;

import interpres.language.definitions.Definition;

public class StringToList extends Definition {

  public StringToList() {
    super("core.string-to-list", new LambdaExpression((definitionTable, arguments) -> {
      List<AST> characters = new ArrayList<AST>();
      StringValue string = (StringValue) arguments.get(0).evaluate(definitionTable);

      for (char c : string.getLiteral().toCharArray()) {
        characters.add(new CharacterValue(c));
      }

      return new ListExpression(characters);
    }));
  }

}

