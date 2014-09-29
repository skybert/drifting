package net.skybert.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;

@Entity
public class Indian {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = DBConstants.TRIBE_ID)
    private Tribe tribe;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Tribe getTribe() {
        return tribe;
    }

    public String toString() {
        return getClass().getName() + "[" + " id=" + getId() + " name="
                + getName() + "]";
    }

}
