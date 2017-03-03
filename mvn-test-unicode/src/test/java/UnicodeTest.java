
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * UnicodeTest
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 */
public class UnicodeTest {
  @Test
  public void junitCanPrintUnicode() {
    String ghost = "👻";
    String anotherGhost = "👻";
    System.out.println(getClass().getSimpleName() + " " + ghost);
    assertEquals(ghost, anotherGhost);
  }

  @Test
  public void canDealWithUnicodeInTest() {
    String ghost = "👻";
    String anotherGhost = "👻";
    assertEquals(ghost, anotherGhost);

    // see your favourite Unicode table's entry for GHOST
    Integer expected = 128123;
    Integer actual = ghost.codePointAt(0);
    assertEquals(expected, actual);
  }

  @Test
  public void canGetCorrectCodePointOfGermanCharacter() {
    String s = "Veröffentlicht";
    int expected = 246;
    int actual = s.charAt(3);
    assertEquals(expected, actual);
  }
}
