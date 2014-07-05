package interpres;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import java.io.IOException;
import java.io.InputStream;

import java.util.Arrays;

import interpres.ast.AST;
import interpres.ast.ListExpression;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;
import interpres.language.values.List;

public class Evaluator {
  private DefinitionTable definitionTable;
  private String sourceFileName;

  public Evaluator(DefinitionTable definitionTable, String sourceFileName) {
    this.definitionTable = definitionTable;
    this.sourceFileName = sourceFileName;
  }

  public Value evaluate(InputStream inputStream) throws IOException, RecognitionException {
    AST ast = this.transform(this.parse(inputStream));
    return ast.evaluate(this.definitionTable);
  }

  public Value evaluateWithLayout(InputStream inputStream) throws IOException, RecognitionException {
    Value body = this.evaluate(inputStream);
    Value header = this.evaluateHeader();
    Value footer = this.evaluateFooter();
    return new List(Arrays.asList(header, body, footer));
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
    Transformer transformer = new Transformer(nodeStream, this.sourceFileName);
    Transformer.transform_return transformReturn = transformer.transform();

    return transformReturn.ast;
  }

  private Value evaluateHeader() {
    return ListExpression.buildFunctionCall("asm.header").evaluate(this.definitionTable);
  }

  private Value evaluateFooter() {
    return ListExpression.buildFunctionCall("asm.footer").evaluate(this.definitionTable);
  }
}

