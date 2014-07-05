package interpres;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import java.io.IOException;
import java.io.InputStream;

import java.util.Arrays;

import interpres.ast.AST;
import interpres.ast.ListExpression;

import interpres.language.DefinitionTable;
import interpres.language.values.List;

public class Evaluator {
  private DefinitionTable definitionTable;
  private String sourceFileName;

  public Evaluator(DefinitionTable definitionTable, String sourceFileName) {
    this.definitionTable = definitionTable;
    this.sourceFileName = sourceFileName;
  }

  public AsInstructionSequence evaluate(InputStream inputStream) {
    AST ast = this.transform(this.parse(inputStream));
    return ast.evaluate(this.definitionTable);
  }

  public AsInstructionSequence evaluateWithLayout(InputStream inputStream) {
    AsInstructionSequence body = this.evaluate(inputStream);
    AsInstructionSequence header = this.evaluateHeader();
    AsInstructionSequence footer = this.evaluateFooter();
    return new List(Arrays.asList(header, body, footer));
  }

  private CommonTree parse(InputStream inputStream) {
    // Parse the input using the token stream
    GrammarParser parser = new GrammarParser(this.tokenize(inputStream));

    try {
      return (CommonTree) parser.parse().getTree();
    } catch (RecognitionException recognitionException) {
      throw new RuntimeException(recognitionException);
    }
  }

  private CommonTokenStream tokenize(InputStream inputStream) {
    try {
      // Create a token stream
      GrammarLexer lexer = new GrammarLexer(new ANTLRInputStream(inputStream));
      return new CommonTokenStream(lexer);
    } catch (IOException ioException) {
      throw new RuntimeException(ioException);
    }
  }

  private AST transform(CommonTree tree) {
    // Transform the ANTLR tree into an Interpres AST
    CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(tree);
    Transformer transformer = new Transformer(nodeStream, this.sourceFileName);

    try {
      Transformer.transform_return transformReturn = transformer.transform();
      return transformReturn.ast;
    } catch (RecognitionException recognitionException) {
      throw new RuntimeException(recognitionException);
    }
  }

  private AsInstructionSequence evaluateHeader() {
    return ListExpression.buildFunctionCall("asm.header").evaluate(this.definitionTable);
  }

  private AsInstructionSequence evaluateFooter() {
    return ListExpression.buildFunctionCall("asm.footer").evaluate(this.definitionTable);
  }
}

