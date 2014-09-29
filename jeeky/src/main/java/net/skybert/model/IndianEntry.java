package net.skybert.model;

import java.io.*;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import net.skybert.ejb.IndianService;
import net.skybert.data.*;

@Model
public class IndianEntry implements Serializable {
    private static final long serialVersionUID = 1L;

    @Named
    @Produces
    private Indian indian = new Indian();
    @Inject
    IndianService service;

    public long create() {
        return create(indian);
    }

    public long create(final Indian pIndian) {
        return service.create(pIndian);
    }

}
