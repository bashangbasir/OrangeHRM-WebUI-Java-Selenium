package load;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoadPageTest extends BaseTest {

    @Test
    public void testLoadHomepage(){
        Assert.assertEquals(homePage.getPageTitle(),"OrangeHRM", "Incorrect page's tittle.");
    }
}
