package virgin_pulse.step_definitions;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import virgin_pulse.pojo.NewPet;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;

public class CreateNewPetStepDefinition {

    NewPet newPet;
    long petId;

    @Given("user sends a POST request with following information and asserts the creation of new pet")
    public void user_sends_a_post_request_with_following_information_and_asserts_the_creation_of_new_pet(Map<String, String> petMap) {
        newPet = new NewPet(petMap.get("category"), petMap.get("name"),
                petMap.get("photoUrls"), petMap.get("tags"), petMap.get("status"));

// creating a new pet
        petId = given().contentType(ContentType.JSON)
                .body(newPet)
                .when().post("/pet")
                .then().statusCode(200)
                .log().all()
                .extract().jsonPath().getLong("id");

// verifying newly created pet
        given().accept(ContentType.JSON)
                .pathParam("petId", petId)
                .when().get("/pet/{petId}")
                .then().statusCode(200);
    }

    @Given("user should be able to add a picture to a new pet")
    public void user_should_be_able_to_add_a_picture_to_a_new_pet() {
        File petImage = new File("src/test/resources/petImage.jpeg");

//user should be able to add a picture
        given().pathParam("petId", petId)
                .multiPart(petImage)
                .when()
                .post("/pet/{petId}/uploadImage")
                .then().log().all()
                .statusCode(200);
    }
    @Then("user should be able to search for a similar pets")
    public void user_should_be_able_to_search_for_a_similar_pets() {
        Response response = given().accept(ContentType.JSON)
                .when().queryParam("status", "available")
                .get("/pet/findByStatus")
                .then().extract().response();

// creating a list of all available pets
        List<Map<String, String>> listOfAvailablePets = response.as(List.class);

// filtering through the list again to make sure our pet is in the list of all available pets
        List<Map<String, String>> nicksDog = listOfAvailablePets.stream()
                .filter(x -> x.containsValue("NicksDog") && x.containsValue("available")).collect(Collectors.toList());
        for (Map<String, String> eachEntry : nicksDog) {
            Assertions.assertTrue(eachEntry.containsValue("NicksDog"));
        }
    }
}
