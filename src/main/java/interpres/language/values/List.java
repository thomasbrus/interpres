package interpres.language.values;

import java.util.ArrayList;
import java.util.Collections;

import interpres.ast.AST;

public class List extends Value {
  private java.util.List<Value> items;
  private AST listAST;

  public List(java.util.List<Value> items) {
    this(items, null);
  }

  public List(java.util.List<Value> items, AST listAST) {
    this.items = items;
    this.listAST = listAST;
  }

  public static List buildEmpty() {
    return new List(Collections.emptyList());
  }

  public java.util.List<Value> getItems() {
    return this.items;
  }

  public java.util.List<java.lang.String> bytecodeSequence() {
    java.util.List<java.lang.String> bytecodeSequence = new ArrayList<java.lang.String>();

    for (Value item : this.items) {
      bytecodeSequence.addAll(item.bytecodeSequence());
    }

    return bytecodeSequence;
  }

  public AST getUnquotedAST() {
    return this.listAST;
  }

  public java.lang.String toString() {
    return this.items.toString();
  }
}

