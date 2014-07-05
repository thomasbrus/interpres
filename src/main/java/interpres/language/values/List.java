package interpres.language.values;

import java.util.ArrayList;
import java.util.Collections;

import interpres.AsBytecode;
import interpres.ast.AST;

public class List extends Value {
  private java.util.List<AsBytecode> items;

  public List(java.util.List<AsBytecode> items) {
    this.items = items;
  }

  public static List buildEmpty() {
    return new List(Collections.emptyList());
  }

  public java.util.List<AsBytecode> getItems() {
    return this.items;
  }

  public java.util.List<java.lang.String> bytecodeSequence() {
    java.util.List<java.lang.String> bytecodeSequence = new ArrayList<java.lang.String>();

    for (AsBytecode item : this.items) {
      bytecodeSequence.addAll(item.bytecodeSequence());
    }

    return bytecodeSequence;
  }

  public java.lang.String toString() {
    return this.items.toString();
  }
}

