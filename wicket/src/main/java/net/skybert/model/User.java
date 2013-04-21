package net.skybert.model;

import java.io.Serializable;

/**
 * User
 *
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public final class User implements Serializable {
  private static final long serialVersionUID = 1L;
  private String name;
  private String password;

  public User(final String pName, final String pPassword) {
    name = pName;
    password = pPassword;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }
}