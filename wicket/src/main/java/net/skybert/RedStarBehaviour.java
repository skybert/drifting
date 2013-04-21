package net.skybert;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.request.Response;

/**
 * RedStarBehaviour
 * 
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public final class RedStarBehaviour extends Behavior {
  private static final long serialVersionUID = 1L;

  @Override
    public void afterRender(final Component pComponent) {
      FormComponent<?> fc = (FormComponent<?>) pComponent;
      if (!fc.isValid()) {
          Response response = pComponent.getResponse();
          response.write("<span style='color: red;'>*</span>");
      }
    }
}