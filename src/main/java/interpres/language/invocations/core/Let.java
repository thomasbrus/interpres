package interpres.language.invocations.core;

import java.util.List;
import java.util.Iterator;
import java.util.stream.Collectors;

import interpres.ast.AST;
import interpres.ast.Symbol;
import interpres.ast.ListExpression;

import interpres.language.definitions.Definition;
import interpres.language.DefinitionTable;

import interpres.language.values.Value;
import interpres.language.values.Lambda;
import interpres.language.values.Void;

import interpres.language.invocations.Invocation;

public class Let extends Invocation {
  private ListExpression localBindingsAST;
  private List<AST> expressionsAST;

  public Let(DefinitionTable definitionTable, List<AST> arguments) {
    super(definitionTable, arguments);
    this.localBindingsAST = (ListExpression) arguments.get(0);
    this.expressionsAST = arguments.subList(1, arguments.size());
  }

  public Value invoke() {
    this.getDefinitionTable().enterScope();

    this.bindLocals();
    List<Value> evaluatedExpressions = this.evaluateExpressions();

    this.getDefinitionTable().leaveScope();

    return evaluatedExpressions.get(evaluatedExpressions.size() - 1);
  }

  private void bindLocals() {
    Iterator<AST> localBindingsIterator = this.localBindingsAST.getItems().iterator();

    while (localBindingsIterator.hasNext()) {
      String localBindingName = ((Symbol) localBindingsIterator.next()).getName();
      Value localBindingValue = localBindingsIterator.next().evaluate(this.getDefinitionTable());
      this.getDefinitionTable().bind(localBindingName, localBindingValue);
    }
  }

  private List<Value> evaluateExpressions() {
    return this.expressionsAST.stream().map(expression ->
      expression.evaluate(this.getDefinitionTable())
    ).collect(Collectors.toList());
  }
}

