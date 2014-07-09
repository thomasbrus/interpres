package interpres.ast;

import java.util.List;
import java.util.Arrays;

import interpres.language.DefinitionTable;

public class UnquoteExpression extends AST {
  private AST expression;

  public UnquoteExpression(AST expression) {
    this.expression = expression;
  }

  public AST evaluate(DefinitionTable definitionTable) {
    return this.expression.evaluate(definitionTable).evaluate(definitionTable);
  }

  public List<String> instructionSequence() {
    return Arrays.asList(this.expression.toString());
  }
}

