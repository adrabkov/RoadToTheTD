package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.CommonFunctions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static java.net.HttpURLConnection.HTTP_OK;

public class ApiTests {

    private static final int END_YEAR = 1990;

    @DataProvider
    public static Object[][] idFilms() {
        return new Object[][]{
                {1}, {2}, {3}
        };
    }

    @DataProvider
    public static Object[][] listFilm() {
        return new Object[][]{
                {"A New Hope"},
                {"Attack of the Clones"},
                {"The Phantom Menace"},
                {"Revenge of the Sith"},
                {"Return of the Jedi"},
                {"The Empire Strikes Back"},
                {"The Force Awakens"}
        };
    }

    @BeforeClass
    public void setUp() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(this.getClass().getClassLoader().getResource("web.properties").getFile()));
        RestAssured.baseURI = properties.getProperty("base.url");
        RestAssured.requestSpecification = given().log().all();
    }

    @Test(dataProvider = "listFilm")
    public void testFilmList(String film) {
        String jsonPath = "results.title";
        Response response = when()
                .get("/api/films")
                .then()
                .statusCode(HTTP_OK)
                .extract().response();
        JsonPath jsonResponse = response.jsonPath();
        Assert.assertTrue(jsonResponse.getString(jsonPath).contains(film), "Server response does not contain all movies");
    }

    @Test(dataProvider = "idFilms")
    public void testFilmByID(int id) {
        String jsonPath = "release_date";
        String jsonPathName = "title";
        Response response = when()
                .get("/api/films/" + id)
                .then()
                .statusCode(HTTP_OK)
                .extract().response();
        JsonPath jsonResponse = response.jsonPath();
        String dateString = jsonResponse.getString(jsonPath);
        String filmName = jsonResponse.getString(jsonPathName);

        LocalDate dateRelease = LocalDate.parse(dateString);
        Assert.assertTrue(dateRelease.getYear() < END_YEAR, "The " + filmName + "film released later than" + END_YEAR);
    }

    @Test
    public void testFieldFilm() {
        CommonFunctions commonFunctions = new CommonFunctions();
        String jsonPathName = "films";

        Response response = when()
                .get("/api/people/" + commonFunctions.getPeopleID())
                .then()
                .statusCode(HTTP_OK)
                .extract().response();
        JsonPath jsonResponse = response.jsonPath();
        String dateString = jsonResponse.getString(jsonPathName);
        Assert.assertFalse(dateString.isEmpty(), "the films field contains no values");
    }
}
