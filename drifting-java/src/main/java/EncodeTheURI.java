import java.net.*;

public class EncodeTheURI {
  public static void main(String[] a) throws Exception {
    String uri = "/台北都會";
    System.out.println("uri as UTF-8=" + URLEncoder.encode(uri, "UTF-8"));
    System.out.println("uri as UTF-16=" + URLEncoder.encode(uri, "UTF-16"));
  }
}
