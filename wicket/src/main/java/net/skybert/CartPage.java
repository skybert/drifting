package net.skybert;

import java.util.List;

import net.skybert.model.Product;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class CartPage extends WebPage {
  private static final long serialVersionUID = 1L;

  public CartPage(final PageParameters parameters) {
    super(parameters);

    FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
    add(feedbackPanel);

    ShopSession session = (ShopSession) getSession();
    List<Product> cart = session.getCart();

    ListView<Product> listView = new ListView<Product>("cart", cart) {
      private static final long serialVersionUID = -4138277686737875403L;

      @Override
      protected void populateItem(final ListItem<Product> pItem) {
        pItem.setModel(new CompoundPropertyModel<Product>(pItem.getModel()));
        pItem.add(new Label("id"));

        // link
        Link<Void> link = new Link<Void>("link") {
          private static final long serialVersionUID = 1L;

          @Override
          public void onClick() {
            parameters.add("productId", pItem.getModelObject().getId());
            DetailsPage detailsPage = new DetailsPage(parameters);
            setResponsePage(detailsPage);
          }
        };

        link.add(new Label("name"));
        pItem.add(link);
        pItem.add(new Label("price"));
      }
    };

    add(listView);

    Form<Void> form = new StatelessForm<Void>("form");
    add(form);
    form.add(new Button("checkout") {
      private static final long serialVersionUID = 1L;

      @Override
      public void onSubmit() {
        setResponsePage(new ConfirmPage(parameters));
      }
    });
  }
}
