package net.skybert;

import java.util.List;

import net.skybert.model.Customer;
import net.skybert.model.CustomerIdModel;
import net.skybert.model.Order;
import net.skybert.model.OrderItem;
import net.skybert.model.Product;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * OrderPage
 *
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public class OrderPage extends WebPage {
  private static final long serialVersionUID = 1L;
  private IModel<Customer> customerModel;
  private Label customerNameLabel;

  public OrderPage(final PageParameters parameters) {
    // public OrderPage(IModel<Order> pOrderModel) {
    // super(pOrderModel);
    super(parameters);

    Order order = new Order(1);
    order.addOrderItem(new OrderItem(1, new Product(1, "Newspaper", 10d), 1));
    order.addOrderItem(new OrderItem(2, new Product(2, "Milk", 23d), 10));
    order.addOrderItem(new OrderItem(3, new Product(3, "Loaf of Bread", 6.23d), 1));
    
    IModel<Order> orderModel = new Model<Order>(order);
    setDefaultModel(orderModel);

    FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
    add(feedbackPanel);

    Form<Order> form = new Form<>("form");
    add(form);

    customerModel = new PropertyModel<Customer>(getOrderModel(), "customer");

    CustomerIdModel customerIdModel = new CustomerIdModel(WicketApplication
        .get().getCustomerService(), customerModel);
    TextField<Integer> customerIdField = new TextField<Integer>("customerId",
        customerIdModel);
    customerIdField.setRequired(true);
    
    customerIdField.add(new AjaxFormComponentUpdatingBehavior("onkeyup") {
      private static final long serialVersionUID = 1L;

      @Override
      protected void onUpdate(AjaxRequestTarget target) {
        target.add(customerNameLabel);
      }

    });
    form.add(customerIdField);

    customerNameLabel = new Label("customerName", new PropertyModel<String>(
        customerModel, "name"));
    customerNameLabel.setOutputMarkupId(true);
    form.add(customerNameLabel);

    form.add(createOrderItemView());
    form.add(new Label("total", new PropertyModel<Double>(getOrderModel(),
        "total")));
  }

  @SuppressWarnings("unchecked")
  private IModel<Order> getOrderModel() {
    return (IModel<Order>) getDefaultModel();
  }

  private ListView<OrderItem> createOrderItemView() {
    ListView<OrderItem> listView = new ListView<OrderItem>("eachProductItem",
        new PropertyModel<List<OrderItem>>(getOrderModel(), "orderItemList")) {
      private static final long serialVersionUID = 1L;

      @Override
      protected void populateItem(ListItem<OrderItem> pOrderItem) {
        pOrderItem.setDefaultModel(new CompoundPropertyModel<OrderItem>(
            pOrderItem.getModel()));
        pOrderItem.add(new Label("productId", new PropertyModel<Integer>(
            pOrderItem.getModel(), "product.id")));
        pOrderItem.add(new Label("productName", new PropertyModel<Integer>(
            pOrderItem.getModel(), "product.name")));
        pOrderItem.add(new Label("price", new PropertyModel<Integer>(
            pOrderItem.getModel(), "product.price")));
        pOrderItem.add(new Label("quantity", new PropertyModel<Integer>(
            pOrderItem.getModel(), "quantity")));
        pOrderItem.add(new Label("sum", new PropertyModel<Integer>(
            pOrderItem.getModel(), "sum")));
      }

    };
    return listView;

  }
}