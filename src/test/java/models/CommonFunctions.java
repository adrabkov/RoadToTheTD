package models;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.when;

public class CommonFunctions {

    private int peopleID = randomId();

    private static int randomId() {
        Response response = when()
                .get("/api/people")
                .then()
                .extract().response();
        JsonPath jsonResponse = response.jsonPath();
        String count = jsonResponse.getString("count");
        return 1 + (int) (Math.random() * Integer.parseInt(count));
    }

    public int getPeopleID() {
        return peopleID;
    }
}
