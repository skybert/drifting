package net.skybert.ejb;

import javax.inject.Named;
import net.skybert.data.*;
import java.util.*;
import javax.ejb.*;
import javax.persistence.*;

@Stateless
public class IndianServiceImpl implements IndianService
{

  @PersistenceContext
  private EntityManager entityManager;

  public long create(Indian indian)
  {
    System.out.println(getClass() + " create=" + indian);

    entityManager.persist(indian);
    return indian.getId();
  }

  public List<Indian> allIndians()
  {
    TypedQuery<Indian> query = entityManager.createQuery(
        "select i from indian i", Indian.class);
    List<Indian> result = query.getResultList();
    return result;
  }
}
