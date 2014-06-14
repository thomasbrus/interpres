package interpres.ast;

import java.util.List;
import org.antlr.runtime.tree.*;

public class SymbolicExpression extends AST {
  private AST functionName;
  private List<AST> arguments;

  public SymbolicExpression(AST functionName, List<AST> arguments) {
    this.functionName = functionName;
    this.arguments = arguments;
  }

  public List<Object> evaluate() {
    return null;
  }
}

