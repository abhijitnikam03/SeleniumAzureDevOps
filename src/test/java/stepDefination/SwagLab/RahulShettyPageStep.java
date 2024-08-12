package stepDefination.SwagLab;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageFactory.SwagLab.RahulShettyPage;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class RahulShettyPageStep {
	
	RahulShettyPage rp;
	
	
	public RahulShettyPageStep() {
		
		rp=new RahulShettyPage(DriverFactory.getDriver()); 
	}
	
	@Given("Check for radio button {string}")
	public void check_for_radio_button(String button) {
		rp.radiobutton(button);
	}
	
	@And("Select suggession country name {string}")
	public void select_suggetion_country_name(String cname) throws InterruptedException {
		rp.country_name(cname);
	}

	@And("Select Dropdown example {string}")
	public void select_dropdown_example(String value) {
		rp.dropdown(value);
	}
	
	@And("Select Check box example {string}")
	public void select_check_box_example(String chkbx) {
		rp.checkbox(chkbx);
	}
	
	@And("Check new window is open or not")
	public void check_new_window_is_open_or_not() throws InterruptedException {
		rp.openwindow();
	}
	
	@And("Check new tab is open or not")
	public void check_new_tab_is_open_or_not() throws InterruptedException {
		rp.opentab();
	}
	
	@And("Check alert is handle")
	public void check_alert_is_handle() throws InterruptedException {
		rp.alerthandle();
	}
	
	@And("Find course amount from table {string}")
	public void find_course_amount_from_table(String course)  {
		rp.tabledata(course);
	}
	
	@And("Enter value in hide field {string}")
	public void enter_value_in_hide_field(String txt)  {
		rp.showbtn();
		rp.entertxt(txt);
	}
	
	@And("Mouseover on page")
	public void mouseover_on_page() throws InterruptedException {
		rp.mouseover();
	}
	
	@And("Switch to frame")
	public void switch_to_frame() throws InterruptedException {
		rp.iframes();
	}
}
