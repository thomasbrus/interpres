package interpres.ast;

import java.util.Arrays;

import interpres.language.DefinitionTable;

import interpres.language.values.Value;
import interpres.language.values.String;
import interpres.language.values.List;

public class Program extends AST {
  private java.util.List<AST> expressions;

  public Program(java.util.List<AST> expressions) {
    this.expressions = expressions;
  }

  public Value evaluate(DefinitionTable definitionTable) {
    Value body = this.evaluateExpressions(definitionTable);
    Value header = this.evaluateHeader(definitionTable);
    Value footer = this.evaluateFooter(definitionTable);
    return new List(Arrays.asList(header, body, footer));
  }


  public List evaluateExpressions(DefinitionTable definitionTable) {
    return (List) ListExpression.buildFunctionCall("core.list", this.expressions)
      .evaluate(definitionTable);
  }

  private Value evaluateHeader(DefinitionTable definitionTable) {
    return ListExpression.buildFunctionCall("asm.header").evaluate(definitionTable);
  }

  private Value evaluateFooter(DefinitionTable definitionTable) {
    return ListExpression.buildFunctionCall("asm.footer").evaluate(definitionTable);
  }
}

