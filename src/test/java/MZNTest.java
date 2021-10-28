import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MZNTest extends BaseTest {

    private static final String URL = "https://developer.mozilla.org/en-US/";

    @Test
    public void loginTest(){
        getDriver().get(URL);
        Assert.assertEquals(getDriver().getCurrentUrl(), URL);
    }
}
