package net.skybert.model;

import net.skybert.service.CustomerService;

import org.apache.wicket.model.IModel;

/**
 * CustomerIdModel
 *
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public final class CustomerIdModel extends ObjectIdModel<Integer, Customer> {
  private static final long serialVersionUID = 1L;
  private CustomerService customerService;

  public CustomerIdModel(final CustomerService pCustomerService,
      final IModel<Customer> pCustomerModel) {
    super(pCustomerModel);
    customerService = pCustomerService;
  }

  @Override
  protected Customer get(Integer id) {
    return customerService.get(id);
  }

}
