Feature: Webdriveruniversity ~ Contact Us Page

  Scenario: Verify message

    Given I navigate to the webdriveruniversity homepage
    When I click on the contact us button
    And User inputs "Hoshina" data in "First Name" field
    And User inputs "Taicho" data in "Last Name" field
    And User inputs "test@gmail.com" data in "Email Address" field