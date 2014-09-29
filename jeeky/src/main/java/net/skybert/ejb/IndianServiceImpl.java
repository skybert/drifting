package net.skybert.ejb;

import net.skybert.data.*;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class IndianServiceImpl implements IndianService {

    @PersistenceContext
    private EntityManager entityManager;

    public long create(Indian indian) {
        entityManager.persist(indian);
        return indian.getId();
    }
}
