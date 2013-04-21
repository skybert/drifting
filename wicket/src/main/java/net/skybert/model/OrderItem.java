package net.skybert.model;

import java.io.Serializable;

/**
 * OrderItem
 *
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public final class OrderItem implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private Product product;
  private int quantity;

  public OrderItem(final int pId, final Product pProduct, final int pQuantity) {
    id = pId;
    product = pProduct;
    quantity = pQuantity;
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
   * @return the product
   */
  public Product getProduct() {
    return product;
  }

  /**
   * @param product
   *          the product to set
   */
  public void setProduct(Product product) {
    this.product = product;
  }

  /**
   * @return the quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * @param quantity
   *          the quantity to set
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getSum() {
    return product.getPrice() * quantity;

  }
}