package interpres.ast;

import java.util.List;
import java.util.stream.Collectors;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;
import interpres.language.values.Lambda;

public class ListExpression extends AST {
  private List<AST> items;

  public ListExpression(List<AST> items) {
    this.items = items;
  }

  public Value evaluate(DefinitionTable definitionTable) {
    Symbol functionNameSymbol = this.getFunction();
    Lambda lambdaValue = (Lambda) functionNameSymbol.evaluate(definitionTable);
    return lambdaValue.getValue().apply(definitionTable, this.getArguments());
  }

  public List<String> quote() {
    return this.items.stream().map(AST::toString).collect(Collectors.toList());
  }

  public List<AST> getItems() {
    return this.items;
  }

  private Symbol getFunction() {
    return (Symbol) this.items.get(0);
  }

  private List<AST> getArguments() {
    return this.items.subList(1, this.items.size());
  }
}
