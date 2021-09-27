Feature: user should be able to create a new pet and add a picture to it

  @API @Smoke
  Scenario: creating and verifying new pet
    Given user send a new pet request with following information
      | categoryName | shepherd                         |
      | petName      | nicksPet                         |
      | photoURLs    | src/test/resources/petImage.jpeg |
      | tagName      | tagNameForNicksPet               |
      | status       | available                        |
    And user should be able to add a picture to it
    Then user should be able to search for new and similar pets
