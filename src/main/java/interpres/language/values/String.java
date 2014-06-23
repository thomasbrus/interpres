package interpres.language.values;

import java.util.Arrays;

public class String extends Value {
  public String(java.lang.String literal) {
    super(literal);
    this.instructions = Arrays.asList(literal);
  }
}

