package interpres.language.invocations.core.list;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;;

import interpres.AsInstructionSequence;

import interpres.ast.AST;
import interpres.ast.VirtualExpression;

import interpres.language.definitions.Definition;
import interpres.language.DefinitionTable;

import interpres.language.values.Value;
import interpres.language.values.Lambda;
import interpres.language.values.List;

import interpres.language.invocations.Invocation;

public class Map extends Invocation {
  private Lambda lambdaValue;
  private List listValue;

  public Map(DefinitionTable definitionTable, java.util.List<AST> arguments) {
    super(definitionTable, arguments);
    this.lambdaValue = (Lambda) this.getLambdaAST().evaluate(definitionTable).getValue();
    this.listValue = (List) this.getListAST().evaluate(definitionTable).getValue();
  }

  public List invoke() {
    return new List(this.listValue.getItems().stream().map(item ->
      this.lambdaValue.getFunction().apply(
        this.getDefinitionTable(), Arrays.asList(new VirtualExpression(item))
      )
    ).collect(Collectors.toList()));
  }

  private AST getLambdaAST() {
    return this.getArguments().get(0);
  }

  private AST getListAST() {
    return this.getArguments().get(1);
  }
}

