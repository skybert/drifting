import java.util.*;
import java.text.*;

/**
 * TimeZones
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 * @version $Revision$ $Date$
 */
public class TimeZones {
  public static void main(String[] args) {
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
    System.out.println(sdf.format(new Date()));

    SimpleDateFormat sdf2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.TAIWAN);
    sdf.setTimeZone(TimeZone.getTimeZone("PST"));
    System.out.println(sdf2.format(new Date()));

  }
}
