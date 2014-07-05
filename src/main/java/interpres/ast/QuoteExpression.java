package interpres.ast;

import java.util.Arrays;
import java.util.List;

import interpres.language.DefinitionTable;

public class QuoteExpression extends AST {
  private AST expression;

  public QuoteExpression(AST expression) {
    this.expression = expression;
  }

  public AST evaluate(DefinitionTable definitionTable) {
    return this.getExpression();
  }

  public AST getExpression() {
    return this.expression;
  }

  public List<String> instructionSequence() {
    return Arrays.asList(this.expression.toString());
  }
}

