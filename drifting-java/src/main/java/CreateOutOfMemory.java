
import java.util.*;

/**
 * CreateOutOfMemory
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 * @version $Revision$ $Date$
 */
public class CreateOutOfMemory {
  public static void main(String[] args) {
    throw new OutOfMemoryError("Requested array size exceeds VM limit");

  }
}
