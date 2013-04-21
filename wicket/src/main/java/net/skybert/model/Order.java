package net.skybert.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Order
 *
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public final class Order implements Serializable {
  private static final long serialVersionUID = 1L;
  private Customer customer;
  private int id;
  private List<OrderItem> orderItemList = new ArrayList<>();
  private Payment payment;
  private double total;

  public Order(final int pId) {
    id = pId;
  }

  /**
   * @return the customer
   */
  public Customer getCustomer() {
    return customer;
  }

  /**
   * @param customer
   *          the customer to set
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
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
   * @return the orderItemList
   */
  public List<OrderItem> getOrderItemList() {
    return orderItemList;
  }

  /**
   * @param orderItemList
   *          the orderItemList to set
   */
  public void setOrderItemList(List<OrderItem> orderItemList) {
    this.orderItemList = orderItemList;
  }

  /**
   * @return the payment
   */
  public Payment getPayment() {
    return payment;
  }

  /**
   * @param payment
   *          the payment to set
   */
  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  /**
   * @return the total
   */
  public double getTotal() {
    double result = 0d;
    for (OrderItem orderItem : orderItemList) {
      result += orderItem.getProduct().getPrice() * orderItem.getQuantity();
    }
    return result;
  }

  /**
   * @param total
   *          the total to set
   */
  public void setTotal(double total) {
    this.total = total;
  }

  public void addOrderItem(final OrderItem pOrderItem) {
    orderItemList.add(pOrderItem);
  }

}