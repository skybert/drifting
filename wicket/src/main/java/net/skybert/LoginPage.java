package net.skybert;

import net.skybert.model.User;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
    
public class LoginPage extends WebPage {
    private static final long serialVersionUID = 1L;
    private String password;
    private String userName;
    
    public LoginPage(final PageParameters parameters) {
        super(parameters);

        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
        add(feedbackPanel);

        TextField<String> userNameField = new TextField<>("userName");
        PasswordTextField passwordField = new PasswordTextField("password");
        
        Form<LoginPage> form = new Form<LoginPage>("form", new CompoundPropertyModel<LoginPage>(this)) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit() {
                if (userName.equals("torstein") && password.equals("loves-bea")) {
                    User user = new User(userName, password);
                    ShopSession shopSession = (ShopSession) getSession();
                    shopSession.setLoggedInUser(user);
                    continueToOriginalDestination();
                    setResponsePage(CataloguePage.class);
                } else {
                    error("Wrong username/password");
                }
            }

        };

        form.add(userNameField);
        form.add(passwordField);

        add(form);

        

    }



    
}
