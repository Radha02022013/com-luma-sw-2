package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
/*
verifyTheTotalItemsDisplayedOnTheWomens
JacketsPage()
* Click on ‘Sale’ Menu tab
* Click on ‘Jackets’ link on left side
under WOMEN’S DEAL Category
* Verify the text ‘Jackets’ is displayed
* Count the Total Item Displayed on Page
and print the name of all items into
console.
* Verify total 12 Items displayed on page.
 */

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        driver.findElement(By.linkText("Sale")).click();
        driver.findElement(By.linkText("Jackets")).click();
        String expectedText = "Jackets";
        String actualText = driver.findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']")).getText();
        Assert.assertEquals("not in correct tab", expectedText, actualText);
        int expectedProductCount = 12;
        List<WebElement> totalitemlist = driver.findElements(By.className("product-item"));
       int actualProductCount = totalitemlist.size();  // Print the total number of products
        System.out.println("Total products are: " + totalitemlist.size());
        Assert.assertEquals("Product count does not match", expectedProductCount, actualProductCount);
//Print all product titles
        for (WebElement productItem : totalitemlist) {
            WebElement productLink = productItem.findElement(By.className("product-item-link"));
            String productTitle = productLink.getText();
            System.out.println("Product title: " + productTitle);
        }
    }


        @After
        public void tearDown () {
            closeBrowser();
        }

    }