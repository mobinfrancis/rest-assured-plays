package GoogleMaps;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import files.addAPI;



public class Add_Place {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body(addAPI.ADD()).
                when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)");
    }
}

// added log().all() method to catch the logs
// added body assertions in the response body("scope", equalTo("APP")
// moved the json file into a new package