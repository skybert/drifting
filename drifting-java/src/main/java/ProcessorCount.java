/**
 * ProcessorCount
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 * @version $Revision$ $Date$
 */
public class ProcessorCount {
  public static void main(String[] args) {
    System.out.println("Number of available processors=" +
                       Runtime.getRuntime().availableProcessors());
  }
}
