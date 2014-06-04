package net.skybert;

import javax.inject.Inject;

public class Record
{
  private Song firstSong;

  @Inject
  public Record(final Song firstSong)
  {
    this.firstSong = firstSong;
  }

  public Song firstSong()
  {
    return firstSong;
  }

  @Override
  public String toString()
  {
    return getClass().getName() + "[" + "firstSong=" + firstSong + "]";
  }
}
