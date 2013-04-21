package net.skybert;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HelloTherePage extends WebPage {
  private static final long serialVersionUID = 1L;
    public HelloTherePage() {
    }
    
    public HelloTherePage(final PageParameters parameters, final String pMessage) {
        super(parameters);
        final Model<String> messagesModel = new Model<>();
        Label messages = new Label("messages", messagesModel);
        add(messages);

        messagesModel.setObject("hi, you entered ["
                                + pMessage + "]"
                                + " renderCount=" + getRenderCount());
        
    }
}








