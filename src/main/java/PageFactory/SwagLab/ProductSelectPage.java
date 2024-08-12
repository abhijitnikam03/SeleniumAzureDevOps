package PageFactory.SwagLab;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSelectPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ProductSelectPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}

	//################### Page Factory ###################
	
	@FindBy(xpath="//*[@data-prefix='fas']")
	WebElement carticon;
	
	//################### Web Element ###################
	
	public void product_select(String product) throws InterruptedException {
		WebElement productname= driver.findElement(By.xpath("//div[contains(text(),'"+ product + "')]//following::div//following-sibling::button"));
		wait.until(ExpectedConditions.elementToBeClickable(productname));
		productname.click();
		
	}
	
	public void click_cart() {
		carticon.click();
	}
	
}
