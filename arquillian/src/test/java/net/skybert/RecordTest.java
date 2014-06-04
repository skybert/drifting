package net.skybert;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class RecordTest
{
  @Inject
  Record record;

  @Deployment
  public static JavaArchive createDeployment()
  {
    JavaArchive javaArchive = ShrinkWrap.create(JavaArchive.class)
        .addClasses(Song.class, Record.class)
        .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    System.out.println("jar=" + javaArchive.toString(true));

    return javaArchive;
  }

  @Test
  public void should_create_greeting()
  {
    Assert.assertEquals("Joy to the world", record.firstSong().name());

    System.out.println("record=" + record);

  }
}
