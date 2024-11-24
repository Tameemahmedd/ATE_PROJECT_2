package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AddToCartSteps {
    WebDriver driver;

    @Given("the user is on the product page")
    public void the_user_is_on_the_product_page() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/");
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
        driver.manage().timeouts().pageLoadTimeout(30, java.util.concurrent.TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        WebElement pagesMenu = driver.findElement(By.linkText("Pages"));
        actions.moveToElement(pagesMenu).perform();
        Thread.sleep(2000);
        WebElement contactLink = driver.findElement(By.linkText("Product Details"));
        Thread.sleep(2000);

        contactLink.click();
    }

    @When("the user clicks on the Add to Cart button")
    public void the_user_clicks_on_the_button() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement addtoCart=driver.findElement(By.cssSelector("button[name='addtocart']"));
        Thread.sleep(3000);
        js.executeScript("arguments[0].click();", addtoCart);

    }
    @And("the user clicks on the Checkout button")
    public void the_user_clicks_on_the_checkout_button() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement checkout= driver.findElement(By.xpath("//a[normalize-space(text())='check out']"));
        Thread.sleep(3000);
        js.executeScript("arguments[0].click();", checkout);    }

    @And("the user fills in the billing address")
    public void the_user_fills_in_the_billing_address() throws InterruptedException {
        driver.findElement(By.id("first_name")).sendKeys("John");
        Thread.sleep(1000);
        driver.findElement(By.id("last_name")).sendKeys("Doe");
        Thread.sleep(1000);
        driver.findElement(By.id("company")).sendKeys("Example Company");
        Thread.sleep(1000);
        driver.findElement(By.id("street_address")).sendKeys("123 Main St");
        Thread.sleep(1000);
        driver.findElement(By.id("street_address2")).sendKeys("123 Main St");
        Thread.sleep(1000);
        driver.findElement(By.id("postcode")).sendKeys("12345");
        Thread.sleep(1000);
        driver.findElement(By.id("city")).sendKeys("Anytown");
        Thread.sleep(1000);
        driver.findElement(By.id("state")).sendKeys("CA");
        Thread.sleep(1000);
        driver.findElement(By.id("phone_number")).sendKeys("5551234567");
        Thread.sleep(1000);
        driver.findElement(By.id("email_address")).sendKeys("john.doe@example.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//label[@class='custom-control-label'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//label[@class='custom-control-label'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//label[@class='custom-control-label'])[3]")).click();
        Thread.sleep(1000);
    }

    @And("the user clicks on the Place Order button")
    public void the_user_clicks_on_the_place_order_button() throws InterruptedException {
        driver.findElement(By.xpath("(//i[contains(@class,'fa fa-circle-o')])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space(text())='Place Order']")).click();
    }
    @Then("the order is placed successfully")
    public void the_order_is_placed_successfully() throws InterruptedException {
        // Add assertions to verify order placement
        Thread.sleep(1000);
        driver.quit();
    }
}