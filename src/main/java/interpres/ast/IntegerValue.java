package interpres.ast;

import java.util.List;
import java.util.Arrays;

import interpres.language.DefinitionTable;

public class IntegerValue extends AST {
  private Integer value;

  public IntegerValue(Integer value) {
    this.value = value;
  }

  public AST evaluate(DefinitionTable definitionTable) {
    return ListExpression.buildFunctionCall("asm/loadl", new QuoteExpression(this))
      .evaluate(definitionTable);
  }

  public Integer getValue() {
    return this.value;
  }

  public List<String> instructionSequence() {
    return Arrays.asList(this.value.toString());
  }
}

