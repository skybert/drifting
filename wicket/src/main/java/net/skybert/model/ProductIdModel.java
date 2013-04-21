package net.skybert.model;

import org.apache.wicket.model.IModel;

/**
 * ProductIdModel
 *
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public final class ProductIdModel extends ObjectIdModel<Integer, Customer> {
  private static final long serialVersionUID = 1L;
  private ProductService customerService;

  public ProductIdModel(final ProductService pCustomerService,
      final IModel<Customer> pCustomerModel) {
    super(pCustomerModel);
    customerService = pCustomerService;
  }

  @Override
  protected Customer get(Integer id) {
    return customerService.get(id);
  }

}
