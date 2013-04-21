package net.skybert.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import net.skybert.model.Customer;

/**
 * CustomerService
 *
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public final class CustomerService implements Serializable {
  private static final long serialVersionUID = 1L;

  final static Map<Integer, Customer> sCustomerMap = new HashMap<>();
    
  static {
    sCustomerMap.put(1, new Customer(1, "Arne"));
    sCustomerMap.put(2, new Customer(2, "Lise"));
    sCustomerMap.put(3, new Customer(3, "Bea"));
  }

  public Customer get(final int pCustomerId) {
    return sCustomerMap.get(pCustomerId);
  }

}