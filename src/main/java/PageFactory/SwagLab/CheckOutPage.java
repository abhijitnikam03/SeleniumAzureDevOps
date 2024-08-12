package PageFactory.SwagLab;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//################### Page Factory ###################

	@FindBy(linkText = "CHECKOUT")
	WebElement checkoutbtn;
	
	//################### Web Element ###################

	public void click_checkoutbtn() {
		wait.until(ExpectedConditions.elementToBeClickable(checkoutbtn));
		checkoutbtn.click();
	}
}
