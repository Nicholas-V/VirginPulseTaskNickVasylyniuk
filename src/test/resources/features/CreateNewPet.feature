Feature: Feature: user should be able to create a new pet and add a picture to it

  @API @Smoke
  Scenario:
    Given user sends a POST request with following information and asserts the creation of new pet
      | category  | Dog                              |
      | name      | NicksNewDog                         |
      | photoUrls | src/test/resources/petImage.jpeg |
      | tags      | tagNameForNicksPet               |
      | status    | available                        |
    And user should be able to add a picture to a new pet
    Then user should be able to search for a similar pets