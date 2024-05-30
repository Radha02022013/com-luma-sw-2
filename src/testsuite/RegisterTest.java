package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/*
verifyThatSignInPageDisplay

* click on the ‘Create an Account’ link
* Verify the text ‘Create New Customer Account’

2. userSholdRegisterAccountSuccessfully

* click on the ‘Create an Account’ link
* Enter First name
* Enter Last name
* Click on checkbox Sign Up for Newsletter
* Enter Emai
* Enter Password
* Enter Confirm Password
* Click on Create an Account button
* Verify the text 'Thank you for
registering with Main Website Store.’
* Click on down aero neare Welcome
* Click on Sign Out link
* Verify the text ‘You are signed out’
 */
public class RegisterTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";


    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
/*
verifyThatSignInPageDisplay

* click on the ‘Create an Account’ link
* Verify the text ‘Create New Customer Account’
 */
    @Test
    public void verifyThatSignInPageDisplay(){
        driver.findElement(By.linkText("Create an Account")).click();
        String expectedText = "Create New Customer Account";
        String actualText = driver.findElement(By.className("base")).getText();
        Assert.assertEquals("Sign in page not displayed", expectedText, actualText);

    }
    /*
    userShouldRegisterAccountSuccessfully
* click on the ‘Create an Account’ link
* Enter First name
* Enter Last name
* Click on checkbox Sign Up for Newsletter
* Enter Emai
* Enter Password
* Enter Confirm Password
* Click on Create an Account button
* Verify the text 'Thank you for
registering with Main Website Store.’
* Click on down aero neare Welcome
* Click on Sign Out link
* Verify the text ‘You are signed out’
     */

    @Test
    public void userShouldRegisterAccountSuccessfully(){

        driver.findElement(By.linkText("Create an Account")).click();
        driver.findElement(By.id("firstname")).sendKeys("manini");
        driver.findElement(By.id("lastname")).sendKeys("sheth");
        driver.findElement(By.id("email_address")).sendKeys("abc134236@gmail.com");
        driver.findElement(By.id("password")).sendKeys("abc@1234");
        driver.findElement(By.id("password-confirmation")).sendKeys("abc@1234");
        driver.findElement(By.xpath("//form[@id='form-validate']//div/div/button")).click();
       String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[@class='page messages']/div[2]/div/div/div")).getText();
       Assert.assertEquals("User is not able to sign in to the website", expectedText, actualText);
        driver.findElement(By.xpath("//div[@class='panel header']/ul/li[2]/span/button[@data-action='customer-menu-toggle']")).click();
        driver.findElement(By.xpath("//div[@class='panel header']/ul/li[2]/div/ul/li[3]/a")).click();
        String expectedLogoutText = "You are signed out";
        String actualLogoutText = driver.findElement(By.xpath("//main[@id='maincontent']/div/h1/span[text()='You are signed out']")).getText();
       Assert.assertEquals("User is not logged out from the system.", expectedLogoutText, actualLogoutText);

    }


    @After
    public void tearDown(){
       // closeBrowser();
    }

}
