package net.skybert.ejb;

import javax.ejb.Local;

import net.skybert.data.*;

import java.util.*;

@Local
public interface IndianService
{

  public List<Indian> allIndians();

  public List<Tribe> allTribes();

  public long create(Indian indian);

  public Object findTribe(Integer valueOf);

  public Object findIndian(Integer valueOf);

  public List<Indian> getIndiansByName(String name);

  public List<Indian> getIndiansByTribeName(String name);
}
