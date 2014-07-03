package interpres.language.values.quoted;

import java.util.List;

import interpres.ast.AST;
import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public interface Unquotable {
  public AST getUnquotedAST();

  default public Value unquote(DefinitionTable definitionTable) {
    return this.getUnquotedAST().evaluate(definitionTable);
  }
}

