

import java.util.*;

/**
 * PrintEnv
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 * @version $Revision$ $Date$
 */
public class PrintEnvTest {
  public static void main(String args[]) {
    Properties envVars = new Properties();
    Map<String, String> envs = System.getenv();
    for ( String key : envs.keySet() )
    {
      String value = envs.get( key );

        key = key.toUpperCase( Locale.ENGLISH );

      envVars.put( key, value );
    }

    System.out.println("envVars=" + envVars);
  }
}
