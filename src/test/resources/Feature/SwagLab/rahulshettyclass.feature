Feature: Check Rahul Shetty academy demo site componant

  @tag1
  Scenario Outline:  Check All Componant
    Given Navigate to page with url "https://rahulshettyacademy.com/AutomationPractice/"
    And Select testdata from excel "<SheetName>" <rownum>
    And Check for radio button
    And Select suggession country name
    And Select Dropdown example
    And Select Check box example
    #	And Check new window is open or not
    #	And Check new tab is open or not
    And Check alert is handle
    And Find course amount from table
    And Enter value in hide field
    And Mouseover on page
    And Switch to frame

    Examples: 
      | SheetName | rownum |
      | Worksheet |      0 |
