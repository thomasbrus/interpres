package interpres;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.stream.*;

import interpres.ast.AST;
import interpres.ast.QuotedExpression;
import interpres.ast.ListExpression;
import interpres.ast.Symbol;

public class App {
  @SuppressWarnings("unchecked")
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

    definitionTable.define("define", (BiFunction<DefinitionTable, List<AST>, Object>) (dt, arguments) -> {
      Symbol symbol = (Symbol) arguments.get(0);
      definitionTable.define(symbol.getName(), arguments.get(1).evaluate(dt));
      return null;
    });

    definitionTable.define("quote", (BiFunction<DefinitionTable, List<AST>, Object>) (DefinitionTable dt, List<AST> arguments) ->
      arguments.get(0)
    );
    // (define println (lambda (string-instructions)
    //   (core.concat
    //     string-instructions
    //     (core.repeat (core.length string-instructions) "CALL put"))))

    definitionTable.define("unquote", (BiFunction<DefinitionTable, List<AST>, Object>) (DefinitionTable dt, List<AST> arguments) ->
      ((QuotedExpression) arguments.get(0)).evaluate(dt).evaluate(dt)
    );
    definitionTable.define("lambda", (BiFunction<DefinitionTable, List<AST>, Object>) (dt, arguments) -> {
      List<AST> formalArguments = ((ListExpression) arguments.get(0)).getItems();
      List<AST> expressions = arguments.subList(1, arguments.size());

      return (BiFunction<DefinitionTable, List<AST>, Object>) (lambdaDt, actualArguments) -> {
        lambdaDt.enterScope();

        for (int i = 0; i < formalArguments.size(); i++) {
          String localBindingName = ((Symbol) formalArguments.get(i)).getName();
          Object localBindingValue = actualArguments.get(i).evaluate(lambdaDt);
          lambdaDt.bind(localBindingName, localBindingValue);
        }

        List<Object> evaluatedExpressions = expressions.stream().map(e -> e.evaluate(lambdaDt)).collect(Collectors.toList());

        lambdaDt.leaveScope();

        return evaluatedExpressions.get(evaluatedExpressions.size() - 1);
      };
    });

    definitionTable.define("core.concat", (BiFunction<DefinitionTable, List<AST>, Object>) (dt, arguments) -> {
      List<Object> concatenatedList = new ArrayList<Object>();

      for (AST ast : arguments) {
        List<Object> item = (List<Object>) ast.evaluate(dt);
        concatenatedList.addAll(item);
      }

      return concatenatedList;
    });

    definitionTable.define("core.repeat", (BiFunction<DefinitionTable, List<AST>, Object>) (dt, arguments) -> {
      List<Object> repeatedList = new ArrayList<Object>();

      Integer count = (Integer) arguments.get(0).evaluate(dt);
      Object repeatable = arguments.get(1).evaluate(dt);

      for (int i = 0; i < count; i++) {
        repeatedList.add(repeatable);
      }

      return repeatedList;
    });

    definitionTable.define("core.length", (BiFunction<DefinitionTable, List<AST>, Object>) (dt, arguments) -> {
      return ((List<Object>) arguments.get(0).evaluate(dt)).size();
    });

    // Evaluate the AST
    System.out.println("Evaluated result:");
    System.out.println(walkReturn.ast.evaluate(definitionTable));
  }
}

