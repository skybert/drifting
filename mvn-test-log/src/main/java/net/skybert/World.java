package net.skybert;

import org.apache.log4j.Logger;

public class World {
  Logger logger = Logger.getLogger(getClass());

  public boolean isInOrder() {
    logger.debug("The world is still in order");
    return true;
  }

}
