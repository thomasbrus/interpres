package interpres.instructions;

public class EmptyInstructionSequenceAtom<ValueType> extends EmptyInstructionSequence {
  private ValueType value = null;

  public EmptyInstructionSequenceAtom(ValueType value) {
    this.value = value;
  }

  public ValueType getValue() {
    return this.value;
  }
}

