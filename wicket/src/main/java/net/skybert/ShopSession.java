package net.skybert;

import java.util.ArrayList;
import java.util.List;

import net.skybert.model.Product;
import net.skybert.model.User;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

public class ShopSession extends WebSession {
    private static final long serialVersionUID = 1L;
    List<Product> productList;
    private User user;

    public ShopSession(final Request pRequest, final Response pResponse) {
        super(pRequest);
        productList = new ArrayList<Product>();
    }

    public void add(final Product pProduct) {
        productList.add(pProduct);
    }

    public List<Product> getCart() {
        return productList;
    }

    public void setLoggedInUser(final User pUser) {
        user = pUser;
    }

    public User getLoggedInUser() {
        return user;
    }
}
