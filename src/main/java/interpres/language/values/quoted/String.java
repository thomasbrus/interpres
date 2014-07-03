package interpres.language.values.quoted;

import interpres.ast.AST;

public class String extends Quoted {
  public String(AST unquotedAST, interpres.language.values.String stringValue) {
    super(unquotedAST, stringValue);
  }

  public java.lang.String getLiteral() {
    return ((interpres.language.values.String) this.getQuotedValue()).getLiteral();
  }
}

