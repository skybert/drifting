package net.skybert;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;
import org.apache.wicket.validation.validator.RangeValidator;
    
public class HelloWorldPage extends WebPage {
    private static final long serialVersionUID = 1L;

    public HelloWorldPage(final PageParameters parameters) {
        super(parameters);

        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
        add(feedbackPanel);
    
        final Size size = new Size(640, 480);
        Form<Size> form = new Form<Size>("form",
                                         new CompoundPropertyModel<Size>(size)) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit() {
                System.out.println("button clicked, hello from " + getClass().getName()
                                   + " page id=" + getPageId() + " action url=" + getActionUrl()
                                   + " path=" + getPath());
                //                setResponsePage(new
                //                HelloTherePage(parameters,
                //                somethingModel.getObject().toString()));
            }
        };

        TextField<Integer> widthField = new TextField<Integer>("width");
        TextField<Integer> heightField = new TextField<Integer>("height");
        form.add(widthField);
        form.add(heightField);

        form.visitChildren(FormComponent.class, new IVisitor<FormComponent<?>, Void>() {
            @Override
            public void component(FormComponent<?> pComponent, IVisit<Void> pVisitor) {
                pComponent.add(new RedStarBehaviour());
            }
        });

        // visit all integer components
        form.visitChildren(FormComponent.class, new IVisitor<FormComponent<Integer>, Void>() {
            @Override
            public void component(FormComponent<Integer> pComponent, IVisit<Void> pVisitor) {
                pComponent.add(new RangeValidator<Integer>(0, 140));
                pComponent.add(new RangeValidator<Integer>(0, 140));
            }
        });
        
        add(form);
    }
  
    private class Size implements Serializable {
        private static final long serialVersionUID = 8146473687314577962L;
        
        private int width;
        private int height;

        public Size(final int pWidth, final int pHeight) {
            width = pWidth;
            height = pHeight;
        }
        
        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }
}
