package net.skybert.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Tribe
{

  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  public Integer getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(final String pName)
  {
    name = pName;
  }

  public String toString()
  {
    return getClass().getName() + "[" + " id=" + getId() + " name=" + getName()
        + "]";
  }
}
