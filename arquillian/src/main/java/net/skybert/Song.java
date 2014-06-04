package net.skybert;

import javax.annotation.PostConstruct;

public class Song
{
  private String name;

  @PostConstruct
  public void createTheNameOfTheSong()
  {
    name = "Joy to the world";
  }

  public String name()
  {
    return name;
  }

  @Override
  public String toString()
  {
    return getClass().getName() + "[name=" + name + "]";
  }

}
