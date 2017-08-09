import java.util.*;

/**
 * GetStackTrace
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 * @version $Revision$ $Date$
 */
public class GetStackTrace {

  private static void print(final String pMessage) {
    StackTraceElement callee = Thread.currentThread().getStackTrace()[2];
    System.out.println(
      Thread.currentThread().getStackTrace()[2].getFileName() + ":" +
      Thread.currentThread().getStackTrace()[2].getLineNumber() + ":" +
      Thread.currentThread().getStackTrace()[2].getMethodName() + "() " +
      pMessage);
  }

  private static void checkoutSource(final String pURL) {
    print("Checking out " + pURL + " ...");
  }

  private static void compileSource(final String pDir) {
    print("Compiling source in " + pDir + " ...");
  }

  private static void startDevServer(final String pPort) {
    print("Starting dev server on port " + pPort + " ...");
  }

  public static void main(String args[]) {
    checkoutSource("https://github.com/eclipse/che.git");
    compileSource("che");
    startDevServer("8080");
  }
}
