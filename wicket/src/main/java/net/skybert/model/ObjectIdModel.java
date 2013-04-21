package net.skybert.model;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * ObjectIdModel
 *
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public abstract class ObjectIdModel<K, T> implements IModel<K> {
  private static final long serialVersionUID = 1L;
  private IModel<T> objectModel;

  public ObjectIdModel(IModel<T> pObjectModel) {
    objectModel = pObjectModel;
  }

  public K getObject() {
    return new PropertyModel<K>(objectModel, getIdPropertyName()).getObject();
  }

  public void setObject(K pId) {
    T object = get(pId);
    if (object != null) {
      objectModel.setObject(object);
    } else {
      objectModel.setObject(null);
    }
  }
  
  @Override
  public void detach() {
      objectModel.detach();
  }

  protected String getIdPropertyName() {
      return "id";
  }

  protected abstract T get(K id);

}
