package interpres;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import java.util.List;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.stream.*;

import interpres.ast.AST;
import interpres.ast.QuotedExpression;
import interpres.ast.ListExpression;
import interpres.ast.Symbol;

import interpres.definitions.DefinitionTable;
import interpres.instructions.PrintableInstructionSequence;

public class App {
  private DefinitionTable definitionTable;

  public App(DefinitionTable definitionTable) {
    this.definitionTable = definitionTable;
  }

  public PrintableInstructionSequence evaluate(InputStream inputStream) throws IOException, RecognitionException {
    AST ast = this.transform(this.parse(inputStream));
    return ast.evaluate(this.definitionTable);
  }

  private CommonTree parse(InputStream inputStream) throws IOException, RecognitionException {
    // Create a token stream
    GrammarLexer lexer = new GrammarLexer(new ANTLRInputStream(inputStream));
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    // Parse the input using the token stream
    GrammarParser parser = new GrammarParser(tokens);
    return (CommonTree) parser.parse().getTree();
  }

  private AST transform(CommonTree tree) throws RecognitionException {
    // Transform the ANTLR tree into an Interpres AST
    CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(tree);
    TreeWalker walker = new TreeWalker(nodeStream);
    TreeWalker.walk_return walkReturn = walker.walk();

    return walkReturn.ast;
  }

  public static void main(String[] args) throws IOException, RecognitionException {
    DefinitionTable definitionTable = new DefinitionTable();

    definitionTable.define(new interpres.definitions.core.Define());
    definitionTable.define(new interpres.definitions.core.Lambda());
    definitionTable.define(new interpres.definitions.core.Quote());
    definitionTable.define(new interpres.definitions.core.Unquote());
    definitionTable.define(new interpres.definitions.core.Concat());
    definitionTable.define(new interpres.definitions.core.Repeat());
    definitionTable.define(new interpres.definitions.core.Length());

    App app = new App(definitionTable);

    PrintableInstructionSequence instructions = app.evaluate(System.in);
    instructions.printInstructionSequence(new PrintStream(System.out));
  }
}

