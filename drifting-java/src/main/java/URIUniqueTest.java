
import java.net.*;
import java.util.*;

/**
 * URIUniqueTest
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 * @version $Revision$ $Date$
 */
public class URIUniqueTest {
  public static void main(String[] args) throws Exception {
    String url = "http://example.com/test";
    URI one = URI.create(url);
    URI two = URI.create(url + "/");
    System.out.println("one=" + one + " two=" + two + " equal? " + one.equals(two));
    System.out.println("one=" + one.normalize() + " two=" + two.normalize() + " equal? " + one.normalize().equals(two.normalize()));

  }
}
