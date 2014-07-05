package interpres.language.values;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintStream;

import interpres.AsBytecode;
import interpres.ast.AST;
import interpres.language.DefinitionTable;

public abstract class Value implements AsBytecode {
  public List<java.lang.String> bytecodeSequence() {
    return new ArrayList<java.lang.String>();
  }
}

