package net.skybert;

import net.skybert.service.CustomerService;

import org.apache.wicket.Session;
import org.apache.wicket.authorization.strategies.page.SimplePageAuthorizationStrategy;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 *
 * @see net.skybert.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
  private CustomerService customerService;

  /**
   * @see org.apache.wicket.Application#getHomePage()
   */
  @Override
  public Class<? extends WebPage> getHomePage() {
    return OrderPage.class;
  }

  /**
   * @see org.apache.wicket.Application#init()
   */
  @Override
  public void init() {
    super.init();

    // add your configuration here
    getSecuritySettings().setAuthorizationStrategy(
        new SimplePageAuthorizationStrategy(AuthorizedPage.class,
            LoginPage.class) {
          protected boolean isAuthorized() {
            return ((ShopSession) Session.get()).getLoggedInUser() != null;
          }
        });

    customerService = new CustomerService();
  }

  public CustomerService getCustomerService() {
    return customerService;
  }

  @Override
  public Session newSession(final Request pRequest, final Response pResponse) {
    return new ShopSession(pRequest, pResponse);
  }

  public static WicketApplication get() {
    return (WicketApplication) WebApplication.get();
  }

}
