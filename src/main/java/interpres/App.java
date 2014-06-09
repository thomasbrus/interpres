package interpres;

import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import interpres.ast.Node;

public class App {
  public static void main(String[] args) throws IOException, RecognitionException {
    // Create a token stream
    GrammarLexer lexer = new GrammarLexer(new ANTLRInputStream(System.in));
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    // Parse the input using the token stream
    GrammarParser parser = new GrammarParser(tokens);
    CommonTree tree = (CommonTree)parser.parse().getTree();

    // Transform the ANTLR tree into a Java AST
    CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
    TreeWalker walker = new TreeWalker(nodes);
    TreeWalker.walk_return walkReturn = walker.walk();
    
    // Evaluate the AST
    System.out.println(walkReturn.node.evaluate());
  }
}

