package net.skybert;

import java.util.List;

import net.skybert.model.Product;
import net.skybert.model.User;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ConfirmPage extends AuthorizedPage {
  private static final long serialVersionUID = 1L;

  public ConfirmPage(final PageParameters parameters) {
    super(parameters);
    ShopSession session = ((ShopSession) getSession());
    double total = 0;
    List<Product> productList = session.getCart();
    for (Product product : productList) {
      total += product.getPrice();
    }

    User user = session.getLoggedInUser();
    
    String overview = "Hi, " + user.getName() + ", you have bought "
        + productList.size() + " products.";
    add(new Label("overview", overview));
    add(new Label("total", Double.toString(total)));

    Form<Void> form = new StatelessForm<Void>("form");

    form.add(new Button("confirm") {
      private static final long serialVersionUID = 1L;

      @Override
      public void onSubmit() {
          setResponsePage(ThankYouPage.class);
      }
    });

    add(form);
  }
}
