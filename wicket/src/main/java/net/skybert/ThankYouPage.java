package net.skybert;

import net.skybert.model.User;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ThankYouPage extends WebPage {
  private static final long serialVersionUID = 1L;

  public ThankYouPage(final PageParameters parameters) {
    super(parameters);
    ShopSession session = ((ShopSession) getSession());

    User user = session.getLoggedInUser();

    String message = "Thank you so much " + user.getName() + "!";
    Label messageLabel = new Label("message", message);
    add(messageLabel);

    add(new Link<Void>("onward") {
      private static final long serialVersionUID = 1L;

      @Override
      public void onClick() {
          setResponsePage(CataloguePage.class);
      }
    });
  }
}
