package net.skybert;

import net.skybert.model.Product;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class DetailsPage extends WebPage {
  private static final long serialVersionUID = 1L;

  public DetailsPage(final PageParameters parameters) {
    super(parameters);
    final Product product = CataloguePage.getProductById(parameters.get("productId")
        .toInt());

    FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
    add(feedbackPanel);

    add(new Label("id", new PropertyModel<Integer>(product, "id")));
    add(new Label("name", new PropertyModel<String>(product, "name")));
    add(new Label("price", new PropertyModel<Double>(product, "price")));

    Form<Void> form = new StatelessForm<Void>("form");
    Button addToCart = new Button("addToCart") {
      private static final long serialVersionUID = 1L;

      @Override
      public void onSubmit() {
        ShopSession session = (ShopSession) getSession();
        session.add(product);
        setResponsePage(CartPage.class, parameters);

      }
    };

    Button goBackToCatalogue = new Button("goBackToCatalogue") {
      private static final long serialVersionUID = 1L;

      @Override
      public void onSubmit() {
        setResponsePage(CataloguePage.class, parameters);
      }
    };

    form.add(addToCart);
    form.add(goBackToCatalogue);

    add(form);
  }

}
