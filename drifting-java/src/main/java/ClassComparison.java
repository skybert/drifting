
import java.util.*;

/**
 * ClassComparison
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 * @version $Revision$ $Date$
 */
public class ClassComparison {
  public static void main(String[] args) {
    System.out.println(ArrayList.class.isAssignableFrom(List.class));
    System.out.println(List.class.isAssignableFrom(ArrayList.class));

  }

}
