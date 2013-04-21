package net.skybert;

import java.util.ArrayList;
import java.util.List;

import net.skybert.model.Product;
import net.skybert.model.User;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class CataloguePage extends WebPage {
  private static final long serialVersionUID = 1L;

  private final static List<Product> productList = new ArrayList<Product>();
  static {
    productList.add(new Product(1, "Chain lube", 10.00));
    productList.add(new Product(2, "Hose", 30.00));
    productList.add(new Product(3, "Tire", 120.00));
  }

  public static Product getProductById(final int pProductId) {
    for (Product product : productList) {
      if (product.getId() == pProductId) {
        return product;
      }
    }

    return null;
  }

  public CataloguePage(final PageParameters parameters) {
    super(parameters);

    FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
    add(feedbackPanel);

    ListView<Product> listView = new ListView<Product>("productList",
        productList) {
      private static final long serialVersionUID = -4138277686737875403L;

      @Override
      protected void populateItem(final ListItem<Product> pItem) {
        pItem.setModel(new CompoundPropertyModel<Product>(pItem.getModel()));
        pItem.add(new Label("id"));

        PageParameters pageParameters = new PageParameters();
        pageParameters.add("productId", pItem.getModelObject().getId());
        BookmarkablePageLink<Void> link = new BookmarkablePageLink<Void>(
            "link", DetailsPage.class, pageParameters);

        link.add(new Label("name"));
        pItem.add(link);

        pItem.add(new Label("price"));
      }
    };

    add(listView);

    ShopSession shopSession = (ShopSession) getSession();
    User loggedInUser = shopSession.getLoggedInUser();
    if (loggedInUser != null) {
      add(new Label("login", "Hello " + loggedInUser.getName()));
      add(new StatelessLink<Void>("logout") {
        private static final long serialVersionUID = 1L;

        @Override
        public void onClick() {
          getSession().invalidate();
          setResponsePage(CataloguePage.class);
        }
      });
    } else {
      add(new BookmarkablePageLink<Void>("login", LoginPage.class));
      add(new Label("logout", ""));
    }
  }

}
