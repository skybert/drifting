

import java.util.*;
import java.sql.*;

/**
 * DBTimestampPrinter
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 * @version $Revision$ $Date$
 */
public class DBTimestampPrinter {

  public static void main(String[] args) throws Exception {
    // org/mariadb/jdbc/Driver.class
    //        Class.forName("com.mysql.jdbc.Driver");
    Connection dbConn = (Connection) DriverManager.getConnection(
      "jdbc:mysql://foo:3306/kodak?useUnicode=true&characterEncoding=utf8",
      "foo",
      "bar");
    Statement stmt = dbConn.createStatement();

    PreparedStatement updateStatement = dbConn.prepareStatement(
      "insert into tees values (?)");
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    updateStatement.setTimestamp(1, timestamp);
    updateStatement.executeUpdate();

    String query = "select * from tees";
    ResultSet rs = stmt.executeQuery(query);
    while (rs.next()) {
      Timestamp ts = rs.getTimestamp("ts");
      System.out.println(
        "timestamp=" + ts.toString() + " millis=" + ts.getTime());
    }
  }
}
