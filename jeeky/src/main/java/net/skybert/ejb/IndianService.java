package net.skybert.ejb;

import javax.ejb.Local;
import net.skybert.data.*;
import java.util.*;

@Local
public interface IndianService
{

  public List<Indian> allIndians();

  public long create(Indian indian);
}
