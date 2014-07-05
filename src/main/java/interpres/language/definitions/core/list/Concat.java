package interpres.language.definitions.core.list;

import java.util.ArrayList;

import interpres.AsInstructionSequence;

import interpres.ast.AST;
import interpres.language.definitions.Definition;

import interpres.language.values.Value;
import interpres.language.values.Lambda;
import interpres.language.values.List;

public class Concat extends Definition {

  public Concat() {
    super("core.list.concat", new Lambda((definitionTable, arguments) -> {
      java.util.List<AsInstructionSequence> concatenatedItems = new ArrayList<AsInstructionSequence>();

      for (AST argument : arguments) {
        List listValue = (List) argument.evaluate(definitionTable).getValue();
        concatenatedItems.addAll(listValue.getItems());
      }

      // TODO: Fixme
      return new List(concatenatedItems);
    }));
  }

}

