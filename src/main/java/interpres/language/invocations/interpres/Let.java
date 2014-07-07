package interpres.language.invocations.interpres;

import java.util.List;
import java.util.Iterator;
import java.util.stream.Collectors;

import interpres.ast.AST;
import interpres.ast.Symbol;
import interpres.ast.ListExpression;

import interpres.language.definitions.Definition;
import interpres.language.DefinitionTable;

import interpres.language.invocations.Invocation;

public class Let extends Invocation {
  public Let(DefinitionTable definitionTable, List<AST> arguments) {
    super(definitionTable, arguments);
  }

  public AST invoke() {
    this.getDefinitionTable().enterScope();

    this.bindLocals();
    List<AST> evaluatedExpressions = this.evaluateExpressions();

    this.getDefinitionTable().leaveScope();

    return evaluatedExpressions.get(evaluatedExpressions.size() - 1);
  }

  private void bindLocals() {
    Iterator<AST> localBindingsIterator = this.getLocalBindingsAST().getItems().iterator();

    while (localBindingsIterator.hasNext()) {
      String localBindingName = ((Symbol) localBindingsIterator.next()).getName();
      AST localBindingValue = localBindingsIterator.next().evaluate(this.getDefinitionTable());
      this.getDefinitionTable().bind(localBindingName, localBindingValue);
    }
  }

  private List<AST> evaluateExpressions() {
    return this.getExpressionsAST().stream().map(expression ->
      expression.evaluate(this.getDefinitionTable())
    ).collect(Collectors.toList());
  }

  private ListExpression getLocalBindingsAST() {
    return (ListExpression) this.getArguments().get(0).evaluate(this.getDefinitionTable());
  }

  private List<AST> getExpressionsAST() {
    return this.getArguments().subList(1, this.getArguments().size());
  }
}

