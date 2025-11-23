Feature: Webdriveruniversity ~ Contact Us Page

  Scenario: Verify message

    Given I navigate to the webdriveruniversity homepage
    When I click on the contact us link
    And User inputs "Hoshina" data in "First Name" field
    And User inputs "Taicho" data in "Last Name" field
    And User inputs "test@gmail.com" data in "Email Address" field
    And User inputs "test" data in "Comments" field
    And User clicks "SUBMIT" button
    Then User expects "Thank You for your Message!" data to be displayed



    Scenario Outline: Valid Login

      Given I navigate to the webdriveruniversity homepage
      When I click on the login link
      And User inputs "<username>" data in "Username" field
      And User inputs "<password>" data in "Password" field
      And User clicks "Login" button
#      Then User should see a validation succeeded alert

      Examples:
        | username  | password     |
        | webdriver | webdriver123 |