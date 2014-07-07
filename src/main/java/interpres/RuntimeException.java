package interpres;

import java.util.Stack;
import interpres.ast.AST;

public class RuntimeException extends java.lang.RuntimeException {
  private static final long serialVersionUID = 1L;
  private Stack<StackTraceElement> stackTraceElements = new Stack<StackTraceElement>();

  public RuntimeException(String message) {
    super(message);
  }

  public RuntimeException registerFunctionCall(String functionName, String fileName, int lineNumber) {
    this.stackTraceElements.push(new StackTraceElement(
      "main", functionName, fileName, lineNumber
    ));

    return this.updateStackTrace();
  }

  private RuntimeException updateStackTrace() {
    this.setStackTrace(this.stackTraceElements.toArray(
      new StackTraceElement[this.stackTraceElements.size()]
    ));

    return this;
  }
}

