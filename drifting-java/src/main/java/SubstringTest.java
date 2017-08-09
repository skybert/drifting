
import java.util.*;

/**
 * SubstringTest
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 * @version $Revision$ $Date$
 */
public class SubstringTest {
  public static void main(String[] args) {
    String contextPath = "/be1/webservice";
    String proxyPrefix = "";
    System.out.println("contextPath=" + contextPath);
    if (!contextPath.startsWith("/webservice")) {
      proxyPrefix = contextPath.substring(0, contextPath.indexOf("/webservice"));
    }
    System.out.println("proxyPrefix=" + proxyPrefix + " index=" + contextPath.indexOf("/webservice"));

  }
}
