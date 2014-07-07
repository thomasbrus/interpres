package interpres;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.io.File;

import java.nio.file.Path;
import java.nio.file.Paths;

import interpres.ast.AST;

import interpres.language.DefinitionTable;

public class App {
  private Evaluator evaluator;
  private DefinitionTable definitionTable;
  private InputStream inputStream;
  private PrintStream outputStream;
  private Path basePath;

  /**
   * Constructs a new App object.
   *
   * @param pathname the path towards the interpres script to run
   */
  public App(String pathname) throws IOException, RecognitionException{
    this.basePath = Paths.get(pathname).getParent();
    this.inputStream = new FileInputStream(pathname);
    this.outputStream = new PrintStream(System.out);
    this.definitionTable = new DefinitionTable();

    definitionTable.define(new interpres.language.definitions.Require(basePath));
    setupDefinitionTable(this.definitionTable);

    this.evaluator = new Evaluator(definitionTable, (new File(pathname)).getName());
  }

  /**
   * Runs this App object, which will generate instructions.
   */
  public void run() throws IOException, RecognitionException {
    evaluator.evaluateWithLayout(this.inputStream).printInstructionSequence(this.outputStream);
  }

  public static void main(String[] args) throws IOException, RecognitionException {
    new App(args[0]).run();
  }

  private void setupDefinitionTable(DefinitionTable definitionTable) {
    definitionTable.define(new interpres.language.definitions.interpres.Define());
    definitionTable.define(new interpres.language.definitions.interpres.Bind());
    definitionTable.define(new interpres.language.definitions.interpres.Let());
    definitionTable.define(new interpres.language.definitions.interpres.Lambda());
    definitionTable.define(new interpres.language.definitions.interpres.Quote());
    definitionTable.define(new interpres.language.definitions.interpres.Unquote());
    definitionTable.define(new interpres.language.definitions.interpres.Repeat());
    definitionTable.define(new interpres.language.definitions.interpres.List());
    definitionTable.define(new interpres.language.definitions.interpres.StringToList());
    definitionTable.define(new interpres.language.definitions.interpres.IntegerToString());
    definitionTable.define(new interpres.language.definitions.interpres.SymbolToString());
    definitionTable.define(new interpres.language.definitions.interpres.StringToSymbol());
    definitionTable.define(new interpres.language.definitions.interpres.list.Concat());
    definitionTable.define(new interpres.language.definitions.interpres.list.Size());
    definitionTable.define(new interpres.language.definitions.interpres.list.At());
    definitionTable.define(new interpres.language.definitions.interpres.list.Reverse());
    definitionTable.define(new interpres.language.definitions.interpres.list.Map());
    definitionTable.define(new interpres.language.definitions.interpres.list.Reduce());
    definitionTable.define(new interpres.language.definitions.interpres.string.Concat());
    definitionTable.define(new interpres.language.definitions.interpres.symbol.Concat());
    definitionTable.define(new interpres.language.definitions.interpres.character.Ord());
    definitionTable.define(new interpres.language.definitions.interpres.integer.Add());
    definitionTable.define(new interpres.language.definitions.interpres.integer.Subtract());

    definitionTable.define(new interpres.language.definitions.asm.Header());
    definitionTable.define(new interpres.language.definitions.asm.Footer());
  }
}

