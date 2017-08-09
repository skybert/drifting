
import java.util.*;
import java.awt.*;

/**
 * ColorTest
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 * @version $Revision$ $Date$
 */
public class ColorTest {
  public static void main(String[] args) {
    String orig = "#0900cc00";
    System.out.println("orig=" + orig);

    Color color = Color.decode(orig);
    System.out.println(color);

    System.out.println(
      "#" +
      Integer.toHexString(
        color.getRGB()).substring(2));

    System.out.println("alpa=" + Integer.toHexString(color.getAlpha())
                       + " rgb=" + Integer.toHexString(color.getRGB()));
  }
}
