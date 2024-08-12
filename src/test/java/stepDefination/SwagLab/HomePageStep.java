package stepDefination.SwagLab;

import PageFactory.SwagLab.HomePage;
import factory.DriverFactory;
import io.cucumber.java.en.And;

public class HomePageStep {
	
	HomePage hp; 
	
	public HomePageStep() {
		hp=new HomePage(DriverFactory.getDriver());
	}

	@And("Check home page open")
	public void check_home_page_open()  {
	    hp.mainMenu();
	}
	
	@And("Click on all product link")
	public void click_on_all_product_link()  {
	    hp.allmenu();
	}
}
