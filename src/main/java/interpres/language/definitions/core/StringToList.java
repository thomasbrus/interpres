package interpres.language.definitions.core;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.Symbol;
import interpres.ast.AST;

import interpres.language.definitions.Definition;

import interpres.language.values.Value;
import interpres.language.values.Lambda;
import interpres.language.values.Integer;
import interpres.language.values.String;
import interpres.language.values.Character;

public class StringToList extends Definition {

  public StringToList() {
    super("core.string-to-list", new Lambda((definitionTable, arguments) -> {
      List<Value> characters = new ArrayList<Value>();
      String stringValue = (String) arguments.get(0).evaluate(definitionTable);

      for (char c : stringValue.getLiteral().toCharArray()) {
        characters.add(new Character(c));
      }

      return new interpres.language.values.List(characters);
    }));
  }

}

