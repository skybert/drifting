import java.util.*;

/**
 * EnumTest
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 */
public class EnumTest {

  public static void main(String[] args) {
    System.out.println("from upper case=" + Fruit.valueOf("apple".toUpperCase()));
    System.out.println("from lower case=" + Fruit.valueOf("apple"));
  }

  private enum Fruit {
    APPLE,
    ORANGE
  }
}
