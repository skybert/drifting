package net.skybert.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Indian
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  @ManyToOne
  @JoinColumn(name = DBConstants.TRIBE_ID)
  private Tribe tribe;

  public Integer getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setTribe(Tribe tribe)
  {
    this.tribe = tribe;
  }

  public Tribe getTribe()
  {
    return tribe;
  }

  public String toString()
  {
    return getClass().getName() + "[" + "id=" + getId() + " name=" + getName()
        + "]";
  }

}
