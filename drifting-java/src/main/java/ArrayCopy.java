

/**
 * ArrayCopy
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 * @version $Revision$ $Date$
 */
public class ArrayCopy {

  public static void main(String[] args) {
    String[] a  = new String[] { "one", "two" };
    String[] acopy = new String[a.length + 1];
    System.arraycopy(a, 0, acopy, 0, a.length);
    acopy[acopy.length - 1] = "three";

    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
    for (int i = 0; i < acopy.length; i++) {
      System.out.println(acopy[i]);
    }


  }
}
