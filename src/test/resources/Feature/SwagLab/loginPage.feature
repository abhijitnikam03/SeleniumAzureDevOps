Feature: Login page automation

  @tag1
  Scenario: Check for login process in swag lab
    Given Navigate to login page with url "https://www.saucedemo.com/v1/index.html"
    And Enter username "standard_user" and Password "secret_sauce"
    And Click on submit button
		And Check home page open 
		And Click on all product link
    And Select product name "Sauce Labs Bolt T-Shirt"
    And Click on cart option
    And Click on checkout button
    And Enter firstname "abhijit" and Lastname "nikam" and postalcode "395007"
    And click on continue button of check confirmation page 
    
    #//div[contains(text(),'Sauce Labs Bolt T-Shirt')]//following::div//following-sibling::button