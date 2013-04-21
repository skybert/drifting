package net.skybert.model;

import net.skybert.service.CustomerService;

import org.apache.wicket.model.IModel;

/**
 * CustomerIdModel
 *
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public final class CustomerIdModel implements IModel<String> {
  private static final long serialVersionUID = 1L;
  private IModel<Customer> customerModel;
  private CustomerService customerService;

  public CustomerIdModel(final CustomerService pCustomerService,
      IModel<Customer> pCustomerModel) {
    customerService = pCustomerService;
    customerModel = pCustomerModel;
  }

  @Override
  public void setObject(String pObject) {
    Customer customer = customerService.get(Integer.parseInt(pObject));
    if (customer != null) {
      customerModel.setObject(customer);
    } else {
      customerModel.setObject(null);
    }
  }

  @Override
  public String getObject() {
    Customer customer = customerModel.getObject();
    return customer != null ? Integer.toString(customer.getId()) : null;
  }

  @Override
  public void detach() {
    customerModel.detach();
  }
}
