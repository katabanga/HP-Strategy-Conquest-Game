package edu.duke.ece651.team16.server;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.mockito.Mockito.*;

public class AttackOrderTest {
  @Test
  public void test_valid_tryAttack() {
    Territory t1 = new Territory("t1");
    Territory t2 = new Territory("t2");
    t1.setNeighbors(new ArrayList<Territory>(Arrays.asList(t2)));
    List<Territory> Territories = new ArrayList<Territory>();
    Territories.add(t1);
    Connection connection = mock(Connection.class);
    Player p1 = new Player("red", connection, Territories, 1);
    Unit u = new BasicUnit(p1, t1, false, 1);
    t1.tryAddUnits(new ArrayList<Unit>(Arrays.asList(u)));
    Map map = new Map(1);
    AttackOrder at = new AttackOrder(t1, t2, 1, p1, map);
    assertEquals(null, at.tryAttack());
  }

  @Test
  public void test_unvalid_tryAttack() {
    Territory t1 = new Territory("t1");
    Territory t2 = new Territory("t2");
    t1.setNeighbors(new ArrayList<Territory>(Arrays.asList(t2)));
    List<Territory> Territories = new ArrayList<Territory>();
    Territories.add(t1);
    Territories.add(t2);
    Connection connection = mock(Connection.class);
    Player p1 = new Player("red", connection, Territories, 1);
    Unit u = new BasicUnit(p1, t1, false, 1);
    t1.tryAddUnits(new ArrayList<Unit>(Arrays.asList(u)));
    Map map = new Map(1);
    AttackOrder at = new AttackOrder(t1, t2, 1, p1, map);
    assertEquals("You do own the to territory", at.tryAttack());
  }

}