
import java.util.*;
import java.sql.Timestamp;

/**
 * Dater
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 * @version $Revision$ $Date$
 */
public class Dater {

  public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();
    System.out.println("cal=" + cal.getTime() + " millis=" + cal.getTime().getTime());

    Timestamp ts = new Timestamp(
      cal.get(Calendar.YEAR) - 1900,
      cal.get(Calendar.MONTH),
      cal.get(Calendar.DATE),
      cal.get(Calendar.HOUR),
      cal.get(Calendar.MINUTE),
      cal.get(Calendar.SECOND),
      0);
    System.out.println("ts=" + ts + " millis=" + ts.getTime());



  }
}
