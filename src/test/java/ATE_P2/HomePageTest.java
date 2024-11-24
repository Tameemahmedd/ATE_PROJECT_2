package ATE_P2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageTest() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement pagesMenu = driver.findElement(By.linkText("Pages"));
        actions.moveToElement(pagesMenu).perform();
        Thread.sleep(2000);
        WebElement contactLink = driver.findElement(By.linkText("Contact"));
        Thread.sleep(2000);
        contactLink.click();
        Thread.sleep(2000);
    }
}