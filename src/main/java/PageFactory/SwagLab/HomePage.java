package PageFactory.SwagLab;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	public WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}

	//################### Page Factory ###################
	
	@FindBy(xpath="//div[@class='bm-burger-button']")
	WebElement menubutton;
	
	@FindBy(linkText ="All Items")
	WebElement allproduct;
	
	//################### Web Element ###################
	
	public void mainMenu() {		
        wait.until(ExpectedConditions.elementToBeClickable(menubutton));
		menubutton.click();
	}
	
	public void allmenu() {
		wait.until(ExpectedConditions.elementToBeClickable(allproduct));
		allproduct.click();
	}
}
