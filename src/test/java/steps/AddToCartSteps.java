package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartSteps {
    WebDriver driver;

    @Given("the user is on the product page")
    public void the_user_is_on_the_product_page() {
        driver = new ChromeDriver();
        driver.get("http://localhost/single-product-details.html");
    }

    @When("the user clicks on the Add to Cart button")
    public void the_user_clicks_on_the_button() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement addtoCart=driver.findElement(By.cssSelector("button[name='addtocart']"));
        js.executeScript("arguments[0].click();", addtoCart);

    }
    @And("the user clicks on the Checkout button")
    public void the_user_clicks_on_the_checkout_button() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement checkout= driver.findElement(By.xpath("//a[normalize-space(text())='check out']"));
        js.executeScript("arguments[0].click();", checkout);    }

    @And("the user fills in the billing address")
    public void the_user_fills_in_the_billing_address() {
        driver.findElement(By.id("first_name")).sendKeys("John");
        driver.findElement(By.id("last_name")).sendKeys("Doe");
        driver.findElement(By.id("street_address")).sendKeys("123 Main St");
        driver.findElement(By.id("street_address2")).sendKeys("123 Main St");
        driver.findElement(By.id("city")).sendKeys("Anytown");
        driver.findElement(By.id("state")).sendKeys("CA");
        driver.findElement(By.id("postcode")).sendKeys("12345");
        driver.findElement(By.id("phone_number")).sendKeys("5551234567");
        driver.findElement(By.id("email_address")).sendKeys("john.doe@example.com");
        driver.findElement(By.xpath("(//label[@class='custom-control-label'])[1]")).click();
        driver.findElement(By.xpath("(//label[@class='custom-control-label'])[2]")).click();
        driver.findElement(By.xpath("(//label[@class='custom-control-label'])[3]")).click();
    }

    @And("the user clicks on the Place Order button")
    public void the_user_clicks_on_the_place_order_button() {
        driver.findElement(By.xpath("(//i[contains(@class,'fa fa-circle-o')])[1]")).click();
        driver.findElement(By.xpath("//a[normalize-space(text())='Place Order']")).click();
    }
    @Then("the order is placed successfully")
    public void the_order_is_placed_successfully() {
        // Add assertions to verify order placement
        driver.quit();
    }
}