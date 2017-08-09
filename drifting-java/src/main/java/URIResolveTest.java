import java.util.*;
import java.net.*;

/**
 * URIResolveTest
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 * @version $Revision$ $Date$
 */
public class URIResolveTest {

  public static void main(String args[]) throws Exception {
    URI uri = URI.create("http://example.com");
    System.out.println("uri=" + uri);
    System.out.println(uri.resolve("/hei"));
    System.out.println(uri.resolve("/hei").resolve("arne"));
    System.out.println(uri.resolve("/hei").resolve("/arne"));

    uri = URI.create("http://example.com/escenic/person/24");
    System.out.println("uri=" + uri);
    System.out.println(uri.resolve("escenic"));

    uri = URI.create("http://example.com/escenic/person/24?hello=world#myfrag");
    System.out.println("uri=" + uri);
    System.out.println("fragment=" + uri.getFragment());
    System.out.println("query=" + uri.getQuery());
    System.out.println("resolve=" + uri.resolve("#myfrag"));
  }
}
