package interpres.language.definitions.core;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Collectors;

import interpres.ast.AST;
import interpres.ast.Symbol;
import interpres.ast.ListExpression;

import interpres.language.definitions.Definition;

import interpres.language.values.Value;
import interpres.language.values.Lambda;
import interpres.language.values.Void;

public class Let extends Definition {

  public Let() {
    super("core.let", new Lambda((definitionTable, arguments) -> {
      List<AST> localBindingsList = ((ListExpression) arguments.get(0)).getItems();
      Iterator<AST> localBindingsIterator = localBindingsList.iterator();
      List<AST> expressions = arguments.subList(1, arguments.size());

      Map<String, Value> localBindings = new HashMap<String, Value>();

      while (localBindingsIterator.hasNext()) {
        String localBindingName = ((Symbol) localBindingsIterator.next()).getName();
        Value localBindingValue = localBindingsIterator.next().evaluate(definitionTable);
        localBindings.put(localBindingName, localBindingValue);
      }

      definitionTable.enterScope();

      localBindings.forEach((name, value) -> definitionTable.bind(name, value));

      List<Value> evaluatedExpressions = expressions.stream().map(e ->
        e.evaluate(definitionTable)).collect(Collectors.toList());

      definitionTable.leaveScope();

      return evaluatedExpressions.get(evaluatedExpressions.size() - 1);
    }), 0);
  }

}

