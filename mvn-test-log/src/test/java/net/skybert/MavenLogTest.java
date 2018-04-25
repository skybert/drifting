package net.skybert;

import org.junit.*;

public class MavenLogTest {

  @Test
  public void checkIfWorldIsStillInOrder() {
    World world = new World();
    Assert.assertTrue(world.isInOrder());
  }

}
