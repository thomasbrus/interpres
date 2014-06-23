package interpres.language.values;

import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;

public abstract class Value {
  protected Object value;
  protected List<java.lang.String> instructions = new ArrayList<java.lang.String>();

  public Value(Object value) {
    this.value = value;
  }

  public Object getValue() {
    return this.value;
  }

  public List<java.lang.String> getInstructions() {
    return this.instructions;
  }
}

