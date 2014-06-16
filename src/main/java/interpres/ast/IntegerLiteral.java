package interpres.ast;

import java.util.Arrays;
import java.util.List;

public class IntegerLiteral extends AST {
  private Integer value;

  public IntegerLiteral(Integer value) {
    this.value = value;
  }

  public List<Object> evaluate() {
    return Arrays.asList("LOADL " + this.value);
  }

  public String toString() {
    return this.value.toString();
  }
}

