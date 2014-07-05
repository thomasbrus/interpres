package interpres.language.invocations.core;

import java.util.List;
import java.util.Iterator;
import java.util.Collections;
import java.util.stream.Collectors;

import interpres.ast.AST;
import interpres.ast.Symbol;
import interpres.ast.ListExpression;

import interpres.language.definitions.Definition;
import interpres.language.DefinitionTable;

import interpres.language.values.Value;
import interpres.language.values.Lambda;
import interpres.language.values.Integer;

import interpres.language.invocations.Invocation;

public class Bind extends Invocation {
  public Bind(DefinitionTable definitionTable, List<AST> arguments) {
    super(definitionTable, arguments);
  }

  public Value invoke() {
    this.bindLocals();
    return new interpres.language.values.List(Collections.emptyList());
  }

  private void bindLocals() {
    Iterator<AST> localBindingsIterator = this.getLocalBindingsAST().getItems().iterator();

    while (localBindingsIterator.hasNext()) {
      String localBindingName = ((Symbol) localBindingsIterator.next()).getName();
      Value localBindingValue = localBindingsIterator.next().evaluate(this.getDefinitionTable());
      this.getDefinitionTable().bind(localBindingName, localBindingValue);
    }
  }

  private ListExpression getLocalBindingsAST() {
    return (ListExpression) this.getArguments().get(0);
  }
}

