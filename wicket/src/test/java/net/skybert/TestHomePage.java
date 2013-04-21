package net.skybert;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage {
  private WicketTester tester;

  @Before
  public void setUp() {
    tester = new WicketTester(new WicketApplication());
  }

  @Test
  public void cataloguePageRendersSuccessfully() {
    // start and render the test page
    tester.startPage(CataloguePage.class);

    // assert rendered page class
    tester.assertRenderedPage(CataloguePage.class);
  }
    
  @Test
  public void orderPageRendersSuccessfully() {
    // start and render the test page
    tester.startPage(OrderPage.class);

    // assert rendered page class
    tester.assertRenderedPage(OrderPage.class);
  }
}
