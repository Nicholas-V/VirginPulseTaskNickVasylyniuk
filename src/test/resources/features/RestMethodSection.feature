Feature: Validate the user can expand and collapse the rest method sections
  that provide endpoint information on the website

  @UI @Smoke
  Scenario: user should be able to expand and collapse rest methods
    Given user is on the welcome page
    Then the page title should be "Swagger UI"
    Then user verifies all tables expand and collapse
      | petTables   |
      | storeTables |
      | userTables  |
