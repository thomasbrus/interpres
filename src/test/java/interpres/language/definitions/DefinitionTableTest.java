package interpres.language.definitions;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import interpres.language.values.Integer;
import interpres.language.values.Value;
import interpres.language.DefinitionTable;

@RunWith(JUnit4.class)
public class DefinitionTableTest {
  private DefinitionTable definitionTable;
  private Value firstValue;
  private Value secondValue;
  private Value thirdValue;

  @Before public void setUpEmptyDefinitionTable() {
    this.definitionTable = new DefinitionTable();
    this.firstValue = new interpres.language.values.Integer(1);
    this.secondValue = new interpres.language.values.Integer(2);
    this.thirdValue = new interpres.language.values.Integer(3);
  }

  @Test public void defineAddsADefinition() {
    // TODO: Add assertions
  }

  @Test public void defineAddsADefinitionGivenANameAndValue() {
    this.definitionTable.define("x", this.firstValue);
    assertEquals(this.firstValue, this.definitionTable.lookup("x"));
  }

  @Test public void defineOverridesPreviousDefinitions() {
    this.definitionTable.define("x", this.firstValue);
    this.definitionTable.define("x", this.secondValue);
    this.definitionTable.define("x", this.thirdValue);

    assertNotEquals(this.secondValue, this.definitionTable.lookup("x"));
    assertEquals(this.thirdValue, this.definitionTable.lookup("x"));
  }

  @Test public void defineIgnoresScoping() {
    this.definitionTable.enterScope();
    this.definitionTable.define("x", this.firstValue);
    this.definitionTable.leaveScope();

    assertEquals(this.firstValue, this.definitionTable.lookup("x"));
  }

  @Test public void bindAddsADefinition() {
    this.definitionTable.bind("y", this.firstValue);
    assertEquals(this.firstValue, this.definitionTable.lookup("y"));
  }

  @Test public void bindOverridesPreviousDefinitions() {
    this.definitionTable.define("y", this.firstValue);

    this.definitionTable.enterScope();
    this.definitionTable.bind("y", this.firstValue);

    assertEquals(this.firstValue, this.definitionTable.lookup("y"));

    this.definitionTable.enterScope();
    this.definitionTable.bind("y", this.thirdValue);

    assertEquals(this.thirdValue, this.definitionTable.lookup("y"));

    this.definitionTable.leaveScope();
    this.definitionTable.leaveScope();
  }

  @Test public void bindAcknowledgesScoping() {
    this.definitionTable.enterScope();
    this.definitionTable.bind("y", this.firstValue);
    this.definitionTable.bind("z", this.secondValue);

    assertEquals(this.firstValue, this.definitionTable.lookup("y"));

    this.definitionTable.leaveScope();

    assertEquals(null, this.definitionTable.lookup("y"));
  }

  @Test public void lookupFindsADefinition() {
    this.definitionTable.define("x", this.firstValue);
    assertEquals(this.firstValue, this.definitionTable.lookup("x"));

    this.definitionTable.bind("y", this.secondValue);
    assertEquals(this.secondValue, this.definitionTable.lookup("y"));
  }

  @Test public void lookupReturnsNullWhenNothingFound() {
    assertEquals(null, this.definitionTable.lookup("y"));
  }

  // TODO: Add more #lookup tests
  // TODO: Add #enterScope and #leaveScope tests
}

