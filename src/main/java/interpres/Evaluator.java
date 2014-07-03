package interpres;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import java.io.IOException;
import java.io.InputStream;

import interpres.ast.AST;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class Evaluator {
  private DefinitionTable definitionTable;

  public Evaluator(DefinitionTable definitionTable) {
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
}

