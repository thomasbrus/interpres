package interpres.ast;

import java.util.List;
import java.util.ArrayList;

import interpres.AsBytecode;
import interpres.language.DefinitionTable;

public class StringLiteral extends AST {
  private java.lang.String literal;

  public StringLiteral(java.lang.String literal) {
    this.literal = literal;
  }

  public AsBytecode evaluate(DefinitionTable definitionTable) {
    return ListExpression.buildFunctionCall("asm.loads", new QuoteExpression(this))
      .evaluate(definitionTable);
  }

  public java.lang.String getLiteral() {
    return this.literal;
  }
}
