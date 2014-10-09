package net.skybert;

import javax.inject.Inject;

import java.io.*;

import net.skybert.data.Indian;
import net.skybert.data.LanguageFamily;
import net.skybert.data.Tribe;
import net.skybert.interceptor.Logged;
import net.skybert.interceptor.Sauron;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * InjectionTest
 * 
 * @author Torstein Krause Johansen
 * @version 1.0
 */
@RunWith(Arquillian.class)
public class InjectionTest
{
  @Inject
  Indian indian;

  @Deployment
  public static JavaArchive createDeployment()
  {
    JavaArchive jar = ShrinkWrap
        .create(JavaArchive.class)
        .addPackages(true, Tribe.class.getPackage().getName())
        .addPackages(true, Sauron.class.getPackage().getName())
        .addAsManifestResource(new File("src/main/webapp/WEB-INF", "beans.xml"))
        .addAsManifestResource(
            new File("src/main/resources/META-INF", "persistence.xml"));

    System.out.println("jar=" + jar.toString(true));
    return jar;
  }

  @Test
  public void an_indian_can_be_injected()
  {
    Assert.assertNotNull(indian);
    Assert.assertNull(indian.getId());
  }

}
