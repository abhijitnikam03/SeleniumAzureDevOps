package stepDefination.SwagLab;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import PageFactory.SwagLab.RahulShettyPage;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import util.ExcelReader;

public class RahulShettyPageStep {
	
	RahulShettyPage rp;
	String excelpath ="src/test/java/testData/InputData.xlsx";
	ExcelReader reader=new ExcelReader();
	String rediobrtn;
	String cntname;
	String dropdown;
	String coursename;
	String hidevalue;
	
	public RahulShettyPageStep() {
		
		rp=new RahulShettyPage(DriverFactory.getDriver()); 
	}
	
	@Given("Navigate to page with url {string}")
	public void navigate_to_login_page_with_url(String url) {
		DriverFactory.getDriver().navigate().to(url);
	}
	
	@And("Check for radio button")
	public void check_for_radio_button() {
		rp.radiobutton(rediobrtn);
	}
	
	
	@And("Select testdata from excel {string} {int}")
	public void select_testdata_from_excel(String sheetname,int rownum) throws InvalidFormatException, IOException {
		  List<Map<String,String>> listLogin= reader.getData(excelpath, sheetname);
		  rediobrtn=listLogin.get(rownum).get("redio button").trim();
		  cntname=listLogin.get(rownum).get("country name").trim();
		  dropdown=listLogin.get(rownum).get("drop down option").trim();
		  coursename=listLogin.get(rownum).get("course name").trim();
		  hidevalue=listLogin.get(rownum).get("hide value").trim();
		  System.out.println(dropdown);
	}
	
	@And("Select suggession country name")
	public void select_suggetion_country_name() throws InterruptedException {
		rp.country_name(cntname);
	}

	@And("Select Dropdown example")
	public void select_dropdown_example() {
		rp.dropdown(dropdown);
	}
	
	@And("Select Check box example")
	public void select_check_box_example() {
		rp.checkbox(dropdown);
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
	
	@And("Find course amount from table")
	public void find_course_amount_from_table()  {
		rp.tabledata(coursename);
	}
	
	@And("Enter value in hide field")
	public void enter_value_in_hide_field()  {
		rp.showbtn();
		rp.entertxt(hidevalue);
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
