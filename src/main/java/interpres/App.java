package interpres;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.PrintStream;

import java.nio.file.Path;
import java.nio.file.Paths;

import interpres.ast.AST;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class App {
  private Evaluator evaluator;
  private DefinitionTable definitionTable;
  private InputStream inputStream;
  private PrintStream outputStream;
  private Path basePath;

  public App(String filename) throws IOException, RecognitionException{
    this.basePath = Paths.get(filename).getParent();
    this.inputStream = new FileInputStream(filename);
    this.outputStream = new PrintStream(System.out);
    this.definitionTable = new DefinitionTable();

    definitionTable.define(new interpres.language.definitions.Require(basePath));
    setupDefinitionTable(this.definitionTable);

    this.evaluator = new Evaluator(definitionTable);
  }

  public void run() throws IOException, RecognitionException {
    evaluator.evaluateWithLayout(this.inputStream).printBytecode(this.outputStream);
  }

  public static void main(String[] args) throws IOException, RecognitionException {
    new App(args[0]).run();
  }

  private void setupDefinitionTable(DefinitionTable definitionTable) {
    definitionTable.define(new interpres.language.definitions.core.Define());
    definitionTable.define(new interpres.language.definitions.core.Let());
    definitionTable.define(new interpres.language.definitions.core.Lambda());
    definitionTable.define(new interpres.language.definitions.core.Quote());
    definitionTable.define(new interpres.language.definitions.core.Unquote());
    definitionTable.define(new interpres.language.definitions.core.Repeat());
    definitionTable.define(new interpres.language.definitions.core.List());
    definitionTable.define(new interpres.language.definitions.core.StringToList());
    definitionTable.define(new interpres.language.definitions.core.IntegerToString());
    definitionTable.define(new interpres.language.definitions.core.SymbolToString());
    definitionTable.define(new interpres.language.definitions.core.StringToSymbol());
    definitionTable.define(new interpres.language.definitions.core.list.Concat());
    definitionTable.define(new interpres.language.definitions.core.list.Size());
    definitionTable.define(new interpres.language.definitions.core.list.Reverse());
    definitionTable.define(new interpres.language.definitions.core.list.Map());
    definitionTable.define(new interpres.language.definitions.core.string.Concat());
    definitionTable.define(new interpres.language.definitions.core.symbol.Concat());
    definitionTable.define(new interpres.language.definitions.core.character.Ord());
    definitionTable.define(new interpres.language.definitions.core.integer.Add());
    definitionTable.define(new interpres.language.definitions.core.integer.Subtract());

    definitionTable.define(new interpres.language.definitions.asm.Header());
    definitionTable.define(new interpres.language.definitions.asm.Footer());
  }
}

