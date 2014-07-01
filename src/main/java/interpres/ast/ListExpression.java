package interpres.ast;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;
import interpres.language.values.Lambda;

public class ListExpression extends AST {
  private List<AST> items;

  public ListExpression(List<AST> items) {
    this.items = items;
  }

  public static ListExpression buildFunctionCall(String name, List<AST> arguments) {
    List<AST> items = new ArrayList<AST>();
    items.add(new Symbol(name));
    items.addAll(arguments);
    return new ListExpression(items);
  }

  public static ListExpression buildFunctionCall(String name, AST argument) {
    return buildFunctionCall(name, Arrays.asList(argument));
  }

  public Value evaluate(DefinitionTable definitionTable) {
    Lambda lambdaValue = (Lambda) this.getFunction().evaluate(definitionTable);
    return lambdaValue.getFunction().apply(definitionTable, this.getArguments());
  }

  public interpres.language.values.List quote() {
    return new interpres.language.values.List(
       this.items.stream().map(AST::quote).collect(Collectors.toList())
    );
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

