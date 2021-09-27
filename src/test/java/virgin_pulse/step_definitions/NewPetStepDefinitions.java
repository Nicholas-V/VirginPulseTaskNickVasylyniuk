package virgin_pulse.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import virgin_pulse.pojo.Pet;
import virgin_pulse.utilities.PetUtilities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class NewPetStepDefinitions {

    long petId;

    @Given("user send a new pet request with following information")
    public void user_send_a_new_pet_request_with_following_information(Map<String, String> map) {
        Pet nicksPet = PetUtilities.createNewPet(map.get("petName"), map.get("categoryName"),
                map.get("tagName"), map.get("photoURLs"), map.get("status"));

     petId = given().contentType(ContentType.JSON)
                .body(nicksPet).log().all()
                .when().post("/pet")
                .then().statusCode(200)
                .extract().jsonPath().getLong("id");

    }

    @And("user should be able to add a picture to it")
    public void user_should_be_able_to_add_a_picture_to_it() {
        File petImage = new File("src/test/resources/petImage.jpeg");

//user should be able to add a picture
        given().pathParam("petId", this.petId)
                .multiPart(petImage)
                .log().all()
                .when()
                .post("/pet/{petId}/uploadImage")
                .then().log().all()
                .statusCode(200);
    }

    @Then("user should be able to search for new and similar pets")
    public void user_should_be_able_to_search_for_new_and_similar_pets() {

//user should be able to search for newly created pet
        given().accept(ContentType.JSON)
                .pathParam("petId", petId)
                .when().get("/pet/{petId}")
                .then().statusCode(200).log().all()
                .body("name", is("nicksPet"));

//user should be able to search for pets with similar status(available)
        Response response = given().accept(ContentType.JSON)
                .when().queryParam("status", "available")
                .get("/pet/findByStatus")
                .then().extract().response();

        List<Map<String, String>> listOfAvailablePets = response.as(List.class);
        for (Map<String, String> each : listOfAvailablePets) {
            System.out.println(each);
            assertThat(each.get("status"), is("available"));
        }
    }
}
