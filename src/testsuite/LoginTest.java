package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
/*
userShouldLoginSuccessfullyWithValid
Credentials()
* Click on ‘Sign In’ link
* Enter valid Email
* Enter valid Password
* Click on ‘Sign In’ button
* Verify the ‘Welcome’ text is display
 */


    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("email")).sendKeys("abc134236@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("abc@1234");
        driver.findElement(By.id("send2")).click();
      String expectedText = "Welcome";
      String actualText = driver.findElement(By.xpath("//div[@class='panel header']/ul[@class='header links']/li/span[@class='logged-in']")).getText();
      String splitText [] = actualText.split(",");
        Assert.assertEquals(expectedText,splitText[0]);





    }

    @After
    public void tearDown(){
//closeBrowser();
    }
}
