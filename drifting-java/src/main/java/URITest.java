

import java.util.*;
import java.net.*;

/**
 * URITest
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 */
public class URITest {

  public static void main(String[] args) {
    URI uri = URI.create("http://vg.no");
    System.out.println("uri=" + uri);
    System.out.println("port=" + uri.getPort());

  }

}
