package interpres.language.definitions.core;

import java.util.ArrayList;

import interpres.AsInstructionSequence;

import interpres.ast.Symbol;
import interpres.ast.AST;

import interpres.language.definitions.Definition;
import interpres.language.values.Value;
import interpres.language.values.Lambda;

public class List extends Definition {

  public List() {
    super("core.list", new Lambda((definitionTable, arguments) -> {
      java.util.List<AsInstructionSequence> listItems = new ArrayList<AsInstructionSequence>();

      for (AST argument : arguments) {
        AsInstructionSequence listItemValue = argument.evaluate(definitionTable);
        listItems.add(listItemValue);
      }

      return new interpres.language.values.List(listItems);
    }));
  }

}

