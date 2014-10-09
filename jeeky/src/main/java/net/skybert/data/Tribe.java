package net.skybert.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;

@ToString(exclude = "indians")
@Entity
public class Tribe
{
  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  @Enumerated(EnumType.STRING)
  private LanguageFamily languageFamily;

  @Getter
  @OneToMany(mappedBy = "tribe")
  private List<Indian> indians = new ArrayList<>();

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

  public LanguageFamily getLanguageFamily()
  {
    return languageFamily;
  }

  public void setLanguageFamily(LanguageFamily languageFamily)
  {
    this.languageFamily = languageFamily;
  }

  @Override
  public boolean equals(Object other)
  {
    if (!(other instanceof Tribe))
    {
      return false;
    }
    if (other == this)
    {
      return true;
    }
    if (getId() == null)
    {
      return false;
    }

    Tribe otherTribe = (Tribe) other;
    return getId().equals(otherTribe.getId());

  }

}
