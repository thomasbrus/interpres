package interpres.language.values;

import java.util.ArrayList;
import java.util.Collections;

import interpres.AsInstructionSequence;
import interpres.ast.AST;

public class List extends Value {
  private java.util.List<AsInstructionSequence> items;

  public List(java.util.List<AsInstructionSequence> items) {
    this.items = items;
  }

  public static List buildEmpty() {
    return new List(Collections.emptyList());
  }

  public java.util.List<AsInstructionSequence> getItems() {
    return this.items;
  }

  public java.util.List<java.lang.String> instructionSequence() {
    java.util.List<java.lang.String> instructionSequence = new ArrayList<java.lang.String>();

    for (AsInstructionSequence item : this.items) {
      instructionSequence.addAll(item.instructionSequence());
    }

    return instructionSequence;
  }
}

