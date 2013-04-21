package net.skybert.model;

import java.io.Serializable;

/**
 * Product
 *
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public final class Product implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;
  private double price;
  private String name;

  public Product(final int pId, final String pName, final double pPrice) {
    id = pId;
    name = pName;
    price = pPrice;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public double getPrice() {
    return price;
  }
}