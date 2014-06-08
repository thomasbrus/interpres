package interpres;

import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class App {
  public static void main(String[] args) throws IOException, RecognitionException {
    GrammarLexer lexer = new GrammarLexer(new ANTLRInputStream(System.in));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    GrammarParser parser = new GrammarParser(tokens);

    GrammarParser.program_return result = parser.program();
    CommonTree tree = (CommonTree) result.getTree();

    System.out.println(tree.toStringTree());
  }
}

