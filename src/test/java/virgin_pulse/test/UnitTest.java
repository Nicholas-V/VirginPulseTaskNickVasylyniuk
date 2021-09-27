package virgin_pulse.test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class UnitTest {

    @BeforeAll
    public static void setUp(){
        baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void test1() {
        JsonPath jsonPath = given().accept(ContentType.JSON)
                .when().queryParam("status", "available")
                .get("/pet/findByStatus")
                .then().extract().response().jsonPath();

        List<String> list = jsonPath.getList("category.name");
        for (String each : list) {
            if(each!= null && each.equals("shepherd")) System.out.println(each);
            }
        }
    }

