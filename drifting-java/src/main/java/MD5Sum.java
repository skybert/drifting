
import java.util.*;
import java.security.*;

/**
 * MD5Sum
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 * @version $Revision$ $Date$
 */
public class MD5Sum {
  public static void main(String[] args) throws Exception {
    MessageDigest md = MessageDigest.getInstance("MD5");
    byte[] thedigest = md.digest(args[0].getBytes("UTF-8"));
    System.out.println("MD5 hash of " + args[0] + "=" + new String(thedigest));

  }
}
