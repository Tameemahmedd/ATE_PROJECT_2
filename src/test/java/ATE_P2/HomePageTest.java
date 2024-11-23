package ATE_P2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageTest() {
        Actions actions = new Actions(driver);
        WebElement pagesMenu = driver.findElement(By.linkText("Pages"));
        actions.moveToElement(pagesMenu).perform();
        WebElement contactLink = driver.findElement(By.linkText("Contact"));
        contactLink.click();
    }
}