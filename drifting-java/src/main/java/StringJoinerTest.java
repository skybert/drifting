
import java.util.*;
import java.util.stream.*;

/**
 * StringJoinerTest
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 */
public class StringJoinerTest {

  public static void main(String[] args) {
    List<String> numbers = Arrays.asList("one", "two", "3", "4");
    String commaSeparatedNumbers = numbers.stream()
      .collect(Collectors.joining(", "));
    System.out.println("commaSeparatedNumbers=" + commaSeparatedNumbers);

  }
}
