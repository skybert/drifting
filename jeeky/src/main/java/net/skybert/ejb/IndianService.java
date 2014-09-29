package net.skybert.ejb;

import javax.ejb.Local;
import net.skybert.data.*;

@Local
public interface IndianService {

    public long create(Indian indian);
}
