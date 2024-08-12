package stepDefination.SwagLab;

import org.openqa.selenium.support.ui.WebDriverWait;

import PageFactory.SwagLab.ProductSelectPage;
import factory.DriverFactory;
import io.cucumber.java.en.And;

public class ProductSelectPageStep {
	
	ProductSelectPage pd;
	
	public ProductSelectPageStep() {
		pd=new ProductSelectPage(DriverFactory.getDriver());
	}

	@And("Select product name {string}")
	public void select_product_name(String product) throws InterruptedException {
		pd.product_select(product);
	}
	
	@And("Click on cart option")
	public void click_on_cart_option() {
		pd.click_cart();
	}
}
