package stepDefination.SwagLab;

import PageFactory.SwagLab.CheckOutPage;
import factory.DriverFactory;
import io.cucumber.java.en.And;

public class CheckOutPageStep {
	
	CheckOutPage cp;
	
	public CheckOutPageStep() {
		cp = new CheckOutPage(DriverFactory.getDriver());
	}
	
	@And("Click on checkout button")
	public void click_on_checkout_button()  {
		cp.click_checkoutbtn();
	}

}
