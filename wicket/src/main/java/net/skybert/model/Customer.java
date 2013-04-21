package net.skybert.model;

import java.io.Serializable;

/**
 * Customer
 *
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 * @param <Customer>
 */
public final class Customer implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private String name;

  public Customer(final int pId, final String pName) {
    id = pId;
    name = pName;
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id
   *          the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name
   *          the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

}