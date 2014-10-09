package net.skybert.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(exclude = "tribe")
@EqualsAndHashCode
@Entity
public class Indian
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(unique = true)
  private String name;

  @Min(1)
  @Max(200)
  private Integer age;

  @ManyToOne
  // @JoinColumn(name = DBConstants.TRIBE_ID)
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

  public Integer getAge()
  {
    return age;
  }

  public void setAge(Integer age)
  {
    this.age = age;
  }

  public Tribe getTribe()
  {
    return tribe;
  }

}
