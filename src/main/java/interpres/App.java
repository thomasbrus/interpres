package interpres;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import java.io.*;
import java.util.List;
import java.util.function.BiFunction;

import interpres.ast.AST;
import interpres.ast.QuotedExpression;
import interpres.ast.Symbol;

public class App {
  public static void main(String[] args) throws IOException, RecognitionException {
    // Create a token stream
    GrammarLexer lexer = new GrammarLexer(new ANTLRInputStream(System.in));
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    // Parse the input using the token stream
    GrammarParser parser = new GrammarParser(tokens);
    CommonTree tree = (CommonTree)parser.parse().getTree();

    System.out.println("ANTLR syntax tree:");
    System.out.println(tree.toStringTree());

    // Transform the ANTLR tree into a custom AST classes
    CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(tree);
    TreeWalker walker = new TreeWalker(nodeStream);
    TreeWalker.walk_return walkReturn = walker.walk();

    // Setup the definition table
    DefinitionTable definitionTable = new DefinitionTable();

    definitionTable.define("define", (BiFunction<DefinitionTable, List<AST>, Object>) (DefinitionTable dt, List<AST> arguments) -> {
      Symbol symbol = (Symbol) arguments.get(0).evaluate(dt);
      definitionTable.define(symbol.getName(), arguments.get(1).evaluate(dt));
      return null;
    });

    definitionTable.define("quote", (BiFunction<DefinitionTable, List<AST>, Object>) (DefinitionTable dt, List<AST> arguments) ->
      arguments.get(0)
    );

    definitionTable.define("unquote", (BiFunction<DefinitionTable, List<AST>, Object>) (DefinitionTable dt, List<AST> arguments) ->
      ((QuotedExpression) arguments.get(0)).evaluate(dt).evaluate(dt)
    );

    // Evaluate the AST
    System.out.println("Evaluated result:");
    System.out.println(walkReturn.ast.evaluate(definitionTable));
  }
}

