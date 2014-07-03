package interpres.language.values;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintStream;

import interpres.ast.AST;
import interpres.language.DefinitionTable;

public abstract class Value implements AsBytecode {
  public List<java.lang.String> bytecodeSequence() {
    return new ArrayList<java.lang.String>();
  }

  public Iterator<java.lang.String> iterator() {
    return this.bytecodeSequence().iterator();
  }

  public void printBytecode(PrintStream printStream) {
    for (java.lang.String bytecode : this.bytecodeSequence()) {
      printStream.println(bytecode);
    }
  }

  public AST getUnquotedAST() {
    return null;
  }

  public Value unquote(DefinitionTable definitionTable) {
    if (this.getUnquotedAST() instanceof AST) {
      return this.getUnquotedAST().evaluate(definitionTable);
    } else {
      throw new UnsupportedOperationException("Unquoting is not supported for " + this.getClass());
    }
  }
}

