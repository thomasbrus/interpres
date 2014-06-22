package interpres.ast;

import java.util.List;

import interpres.definitions.DefinitionTable;
import interpres.instructions.PrintableInstructionSequence;
import interpres.instructions.EmptyInstructionSequenceLambda;

public class ListExpression extends AST {
  private List<AST> items;

  public ListExpression(List<AST> items) {
    this.items = items;
  }

  public PrintableInstructionSequence evaluate(DefinitionTable definitionTable) {
    AST functionAST = this.getFunction();

    // Assume that the first item is a Symbol and that its definition is a of type Lambda
    Object definition = ((Symbol) functionAST).evaluate(definitionTable);
    EmptyInstructionSequenceLambda lambda = (EmptyInstructionSequenceLambda) definition;

    return lambda.apply(definitionTable, this.getArguments());
  }

  public List<AST> quote() {
    return this.items;
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

