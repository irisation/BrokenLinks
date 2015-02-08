import core.TestBase;
import junit.framework.Assert;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static helpers.WebDriverSingleton.getDriver;

public class BrokenLinksTest extends TestBase {

    @Test
    public void brokenLinksTest() throws IOException {

        List<WebElement> links = getDriver().findElements(By.tagName("a"));
        int i = 0;
        for (WebElement link : links) {
            String text = link.getAttribute("href");
            Assert.assertTrue(Request.Get(link.getAttribute("href")).execute().returnResponse().getStatusLine()
                    .getStatusCode() != 404);
            System.out.println(++i);
        }
    }
}
