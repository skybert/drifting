package net.skybert.ejb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import net.skybert.data.Indian;
import net.skybert.data.Tribe;
import net.skybert.interceptor.Logged;

@Stateless
public class IndianServiceImpl implements IndianService
{

  @PersistenceContext
  private EntityManager entityManager;

  public long create(Indian indian)
  {
    entityManager.persist(indian);
    return indian.getId();
  }

  // Without Produces, nothing is put into the named EL variable.
  @Logged
  @Produces
  @Named("allIndians")
  public List<Indian> allIndians()
  {
    TypedQuery<Indian> query = entityManager.createQuery(
        "select i from Indian i", Indian.class);
    List<Indian> result = query.getResultList();
    return result;
  }

  @Logged
  @Produces
  @Named("allTribes")
  public List<Tribe> allTribes()
  {
    TypedQuery<Tribe> query = entityManager.createQuery(
        "select t from Tribe t", Tribe.class);
    List<Tribe> result = query.getResultList();

    // just for fun
    if (result.size() > 0)
    {
      System.out.println("tribe=" + result.get(0).getName() + " has indians="
          + getIndiansByTribeName(result.get(0).getName()));
    }

    return result;
  }

  @Logged
  @Override
  public Object findTribe(Integer id)
  {
    return entityManager.find(Tribe.class, id);
  }

  @Logged
  @Override
  public Object findIndian(Integer id)
  {
    return entityManager.find(Indian.class, id);
  }

  public List<Indian> getIndiansByName(String name)
  {
    TypedQuery<Indian> query = entityManager.createQuery(
        "select i from Indian i where i.name = :indianName", Indian.class);
    query.setParameter("indianName", name);

    List<Indian> result = query.getResultList();
    return result;
  }

  public java.util.List<Indian> getIndiansByTribeName(String name)
  {
    TypedQuery<Indian> query = entityManager.createQuery(
        "select i from Indian i where i.tribe.name = :tribeName", Indian.class);
    query.setParameter("tribeName", name);

    return query.getResultList();
  }
}
