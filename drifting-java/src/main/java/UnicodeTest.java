
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * UnicodeTest
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 */
public class UnicodeTest {
  public static void main(String[] args) {
    String ghost = "👻";
    System.out.println("This is a ghost from main: " + ghost);
    org.junit.runner.JUnitCore.main("UnicodeTest");
  }

  @Test
  public void junitCanPrintUnicode() {
    String ghost = "👻";
    System.out.println("This is a ghost: " + ghost);
    System.out.println(getClass().getSimpleName() + " " + ghost);
  }
}

/*
 javac UnicodeTest.java -cp
 ~/.m2/repository/junit/junit/4.12/junit-4.12.jar && java  -cp
 $HOME/.m2/repository/junit/junit/4.12/junit-4.12.jar:.:$HOME/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
 UnicodeTest
*/