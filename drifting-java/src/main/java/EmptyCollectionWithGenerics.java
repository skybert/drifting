

import java.util.*;

/**
 * EmptyCollectionWithGenerics
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 * @version $Revision$ $Date$
 */
public class EmptyCollectionWithGenerics {
  public static void main(String[] args) {
    Map<String, String> map = Collections.<String, String>emptyMap();
    System.out.println(map);
  }

}
