package interpres.language.values;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;

public abstract class Value implements AsBytecode {
  public List<java.lang.String> bytecodeSequence() {
    return new ArrayList<java.lang.String>();
  }

  public Iterator<java.lang.String> iterator() {
    return this.bytecodeSequence().iterator();
  }

  public int length() {
    return this.bytecodeSequence().size();
  }
}

