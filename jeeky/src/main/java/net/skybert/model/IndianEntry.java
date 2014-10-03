package net.skybert.model;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import net.skybert.data.Indian;
import net.skybert.data.Tribe;
import net.skybert.ejb.IndianService;
import net.skybert.interceptor.Logged;

@Model
public class IndianEntry implements Serializable
{
  private static final long serialVersionUID = 1L;

  @Named
  @Produces
  private Indian indian = new Indian();

  @Inject
  IndianService service;

  public long create()
  {
    return create(indian);
  }

  public long create(final Indian pIndian)
  {
    return service.create(pIndian);
  }

  @Named
  @Produces
  public Converter getTribeConverter()
  {
    return new Converter()
    {
      @Override
      @Logged
      public Object getAsObject(
        FacesContext context,
        UIComponent component,
        String value)
      {

        return service.findTribe(Integer.valueOf(value));
      }

      @Override
      @Logged
      public String getAsString(
        FacesContext context,
        UIComponent component,
        Object value)
      {
        if (value == null)
        {
          return "";
        }

        return String.valueOf(((Tribe) value).getId());
      }
    };
  }

  @Named
  @Produces
  public Converter getIndianConverter()
  {
    return new Converter()
    {
      @Override
      public Object getAsObject(
        FacesContext context,
        UIComponent component,
        String value)
      {

        return service.findIndian(Integer.valueOf(value));
      }

      @Override
      public String getAsString(
        FacesContext context,
        UIComponent component,
        Object value)
      {
        if (value == null)
        {
          return "";
        }

        return String.valueOf(((Indian) value).getId());
      }
    };
  }
}
