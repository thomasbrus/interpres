package interpres;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.ast.QuotedExpression;
import interpres.ast.ListExpression;
import interpres.ast.Symbol;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class App {
  private DefinitionTable definitionTable;

  public App(DefinitionTable definitionTable) {
    this.definitionTable = definitionTable;
  }

  public Value evaluate(InputStream inputStream) throws IOException, RecognitionException {
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
    definitionTable.define(new interpres.language.definitions.core.character.Ord());
    definitionTable.define(new interpres.language.definitions.core.integer.Add());
    definitionTable.define(new interpres.language.definitions.core.integer.Subtract());
    definitionTable.define(new interpres.language.definitions.core.random.UUID());

    App app = new App(definitionTable);

    Value evaluatedAST = app.evaluate(System.in);
    evaluatedAST.printBytecode(new PrintStream(System.out));
  }
}

