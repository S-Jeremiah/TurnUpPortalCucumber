Feature: TMFeature

  As a Turnup portal admin user
  I should be able to successfully create , edit and delete Time and material records


  Scenario: Create Time Record with valid data
    Given I logged into Turnup portal successfully
    When I navigate to Time and Material page
    When I create a Time Record
    Then the Time Record should be created successfully

  Scenario: Edit Time Record with valid data
    Given I logged into Turnup portal successfully
    When I navigate to Time and Material page
    When I Edit a Time Record
    Then the Time Record should be edited successfully

  Scenario: Delete Time Record with valid data
    Given I logged into Turnup portal successfully
    When I navigate to Time and Material page
    When I delete a Time Record
    Then the Time Record should be deleted successfully

