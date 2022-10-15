package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSD {
	WebDriver driver = Hooks.driver;

	@Given("I have launched the application")
	public void i_have_launched_the_application() {

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@Given("User gives username {string} and password {string}")
	public void user_gives_username_and_password(String userName, String passWord) {

		WebElement userName1 = driver.findElement(By.id("user-name"));
		WebElement passWord1 = driver.findElement(By.id("password"));
		userName1.sendKeys(userName);
		passWord1.sendKeys(passWord);

	}

	@When("User clicks login button")
	public void user_clicks_login_button() {

		WebElement LoginButton = driver.findElement(By.id("login-button"));
		LoginButton.click();

	}

	@Then("user is successfully loged in")
	public void user_is_successfully_loged_in() {
		WebElement HomePage = driver.findElement(By.xpath("//div[@class=\"header_secondary_container\"]/span"));
		String Homepage1 = "PRODUCTS";
		String Home = HomePage.getText();
		Assert.assertEquals(Homepage1, Home);

	}

	@Then("user should get error message {string}")
	public void user_should_get_error_message(String errorMessage1) {
		// Write code here that turns the phrase above into concrete actions
		String ErrorMessage = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(ErrorMessage, errorMessage1);

	}

	@When("Click on Product {string} item add cart")
	public void click_on_Product_item_add_cart(String cart) {
//passing cart name from  scenario
		WebElement item = driver.findElement(By.xpath("//div[text()='" + cart + "']//following::button[1]"));

		// String xpath = "//div[@class='inventory_item_name' and contains(text(), '" +
		// productName + "')]";
		// driver.findElement(By.xpath("//div/button[@name=\"add-to-cart-sauce-labs-bike-light\"]"));
		item.click();

	}

	@Then("itmem will be added")
	public void itmem_will_be_added() {
		WebElement cartItem = driver.findElement(By.xpath("//div/a/span[@class=\"shopping_cart_badge\"]"));
		String items = cartItem.getText();
		Assert.assertEquals(items, "1");
		// div/a/span[@class="shopping_cart_badge"]
	}

}
