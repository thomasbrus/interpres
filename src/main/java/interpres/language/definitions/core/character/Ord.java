package interpres.language.definitions.core.character;

import java.util.Arrays;

import interpres.ast.Symbol;
import interpres.ast.ListExpression;
import interpres.ast.LambdaExpression;
import interpres.ast.CharacterValue;

import interpres.language.definitions.Definition;

public class Ord extends Definition {

  public Ord() {
    super("core.character.ord", new LambdaExpression((definitionTable, arguments) -> {
      CharacterValue character = (CharacterValue) arguments.get(0).evaluate(definitionTable);
      int ord = (int) character.getRepresentation().charValue();
      return new Symbol(Integer.toString(ord));
    }));
  }

}


