package net.skybert.model;

import java.io.Serializable;

/**
 * Payment
 *
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public final class Payment implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private double amount;
  private PaymentMethod paymentMethod;

  public Payment(final double pAmount, final PaymentMethod pPaymentMethod) {
    amount = pAmount;
    paymentMethod = pPaymentMethod;

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
   * @return the amount
   */
  public double getAmount() {
    return amount;
  }

  /**
   * @param amount
   *          the amount to set
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /**
   * @return the paymentMethod
   */
  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  /**
   * @param paymentMethod
   *          the paymentMethod to set
   */
  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

}