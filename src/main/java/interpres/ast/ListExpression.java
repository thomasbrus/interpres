package interpres.ast;

import java.util.List;
import java.util.stream.*;
import java.util.function.BiFunction;

import interpres.DefinitionTable;
import interpres.PrintableBytecode;
import interpres.InstructionSequence;
import interpres.Lambda;

public class ListExpression extends AST {
  private List<AST> items;

  public ListExpression(List<AST> items) {
    this.items = items;
  }

  public PrintableBytecode evaluate(DefinitionTable definitionTable) {
    AST functionAST = this.getFunction();

    // Assume that the first item is a Symbol and that its definition is a of type Lambda
    Lambda lambda = ((Lambda) (((Symbol) functionAST).evaluate(definitionTable)));

    return lambda.apply(definitionTable, this.getArguments());
  }

  public String toString() {
    return this.items.toString();
  }

  public List<AST> getItems() {
    return this.items;
  }

  private AST getFunction() {
    return this.items.get(0);
  }

  private List<AST> getArguments() {
    return this.items.subList(1, this.items.size());
  }
}

