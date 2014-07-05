package interpres.ast;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import interpres.language.DefinitionTable;

public class StringValue extends AST {
  private java.lang.String literal;

  public StringValue(java.lang.String literal) {
    this.literal = literal;
  }

  public AST evaluate(DefinitionTable definitionTable) {
    return ListExpression.buildFunctionCall("asm.loads", new QuoteExpression(this))
      .evaluate(definitionTable);
  }

  public java.lang.String getLiteral() {
    return this.literal;
  }

  public List<String> instructionSequence() {
    return Arrays.asList(this.literal);
  }

  public String toString() {
    return "<'" + this.literal + "'>";
  }
}
