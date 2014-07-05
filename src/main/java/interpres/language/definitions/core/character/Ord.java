package interpres.language.definitions.core.character;

import java.util.Arrays;

import interpres.ast.Symbol;
import interpres.ast.ListExpression;

import interpres.language.definitions.Definition;
import interpres.language.values.Lambda;
import interpres.language.values.Character;

public class Ord extends Definition {

  public Ord() {
    super("core.character.ord", new Lambda((definitionTable, arguments) -> {
      Character characterValue = (Character) arguments.get(0).evaluate(definitionTable).getValue();
      int ord = (int) characterValue.getRepresentation().charValue();
      return new Symbol(Integer.toString(ord));
    }));
  }

}


