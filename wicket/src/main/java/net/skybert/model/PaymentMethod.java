package net.skybert.model;

import java.io.Serializable;

/**
 * PaymentMethod
 *
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public final class PaymentMethod implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private String name;

  public PaymentMethod(final String pName) {
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