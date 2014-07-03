package interpres.language.values.quoted;

import interpres.ast.AST;

public class String extends Quoted {
  public String(AST unquotedAST, java.lang.String literal) {
    super(unquotedAST, new interpres.language.values.String(literal));
  }

  public java.lang.String getLiteral() {
    return ((interpres.language.values.String) this.getQuotedValue()).getLiteral();
  }
}

