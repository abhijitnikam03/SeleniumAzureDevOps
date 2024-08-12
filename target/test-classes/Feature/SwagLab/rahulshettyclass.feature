Feature: Check Rahul Shetty academy demo site componant

  @tag1
  Scenario: Check All Componant
    Given Navigate to login page with url "https://rahulshettyacademy.com/AutomationPractice/"
    And Check for radio button "radio1"
    And Select suggession country name "india"
    And Select Dropdown example "option1"
		And Select Check box example "option1"   
	#	And Check new window is open or not 
	#	And Check new tab is open or not
		And Check alert is handle
		And Find course amount from table "Appium"
		And Enter value in hide field "Abhijit"
		And Mouseover on page
		And Switch to frame 