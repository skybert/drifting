import java.util.*;
import java.net.*;

/**
 * SetTest
 *
 * @author <a href="mailto:torstein@escenic.com">Torstein Krause Johansen</a>
 */
public class SetTest {
  public static void main(String[] args) throws Exception {
    SetTest app = new SetTest();
    app.test();
  }

  private void test() {
    Set<PersonSummary> personSummaries = new HashSet<>();
    personSummaries.add(new PersonSummary("hola", null, URI.create("http://vg.no")));
    personSummaries.add(new PersonSummary("hei", null, URI.create("http://vg.no")));
    personSummaries.add(new PersonSummary("hello", null, URI.create("http://vg.no")));
    personSummaries.add(new PersonSummary("ding", "tkj@foo.comd", null));
    personSummaries.add(new PersonSummary("dong", "tkj@foo.com", null));
    personSummaries.add(new PersonSummary("dong", "tkj@foo.com", null));


    for (PersonSummary ps : personSummaries) {
      System.out.println("ps=" + ps);
    }

  }

  private class PersonSummary {
    URI mURI;
    String mName;
    String mEmail;
    public PersonSummary(String pName, String pEmail, URI pURI) {
      mName = pName;
      mEmail = pEmail;
      mURI = pURI;
    }
    @Override
    public boolean equals(Object o) {
      System.out.println(getClass().getSimpleName() + " equals o=" + o);

      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      PersonSummary that = (PersonSummary) o;

      // if the authors have the same URI, they're the same
      if (mURI != null && that.mURI != null) {
        return mURI.equals(that.mURI);
      }

      // if the authors have the same email address, they're also the
      // same
      if (mEmail != null && that.mEmail != null) {
        return mEmail.equals(that.mEmail);
      }

      // finally, if two authors on the same content item (by line) have
      // the same name, we think they're the same.
      return mName.equals(that.mName);
    }

    @Override
    public int hashCode() {
      int result;
      if (mURI != null) {
        result = mURI.hashCode();
      }
      else if (mEmail != null) {
        result = mEmail.hashCode();
      }
      else {
        result =mName.hashCode();
      }

      System.out.println(getClass().getSimpleName() + " hasCode result=" + result);

      return result;
    }

    public String toString() {
      return getClass() + "["
        + "name=" + mName
        + " email=" + mEmail
        + " mURI=" + mURI
        + "]";
    }
  }
}
