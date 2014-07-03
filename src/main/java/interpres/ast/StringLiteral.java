package interpres.ast;

import java.util.List;
import java.util.ArrayList;

import interpres.language.DefinitionTable;

import interpres.language.values.Value;

public class StringLiteral extends AST {
  private java.lang.String literal;

  public StringLiteral(java.lang.String literal) {
    this.literal = literal;
  }

  public Value evaluate(DefinitionTable definitionTable) {
    return ListExpression.buildFunctionCall("asm.loads", new QuotedExpression(this))
      .evaluate(definitionTable);
  }

  public java.lang.String getLiteral() {
    return this.literal;
  }

  public interpres.language.values.quoted.String quote() {
    return new interpres.language.values.quoted.String(this, this.literal);
  }
}

