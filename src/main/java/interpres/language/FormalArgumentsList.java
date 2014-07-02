package interpres.language;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import java.util.stream.Collectors;
import java.util.function.Function;

import interpres.ast.AST;
import interpres.ast.ListExpression;
import interpres.ast.QuotedExpression;

import interpres.language.DefinitionTable;

public class FormalArgumentsList {
  private ListExpression listExpression;
  private Map<AST, AST> bindings;

  public FormalArgumentsList(ListExpression listExpression) {
    this.listExpression = listExpression;
    this.bindings = new HashMap<AST, AST>();
  }

  public void bindActualArguments(List<AST> actualArguments) {
    for (int i = 0; i < this.getFormalArgumentASTs().size(); i++) {
      if (actualArguments.size() > i) {
        this.bindings.put(this.getFormalArgumentASTs().get(i), actualArguments.get(i));
      } else {
        this.bindings.put(this.getFormalArgumentASTs().get(i), this.getDefaultArgumentASTs().get(i));
      }
    }
  }

  public Map<AST, AST> getBindings() {
    return this.bindings;
  }

  public List<AST> getFormalArgumentASTs() {
    return this.mapArgumentASTs(itemAST -> {
      if (itemAST instanceof ListExpression)
        return ((ListExpression) itemAST).getItem(0);
      else
        return itemAST;
    });
  }

  public List<AST> getDefaultArgumentASTs() {
    return this.mapArgumentASTs(itemAST -> {
      if (itemAST instanceof ListExpression)
        return ((ListExpression) itemAST).getItem(1);
      else
        return null;
    });
  }

  private List<AST> mapArgumentASTs(Function<AST, AST> fn) {
    return this.listExpression.getItems().stream()
      .map(fn).collect(Collectors.toList());
  }
}

