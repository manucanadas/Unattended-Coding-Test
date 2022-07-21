package org.example;

import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UnattendedCodingTest extends BaseTest {

    @Test
    public void validateName() {

        given()
                .when()
                   .get("/Categories/6327/Details.json?catalogue=false")
                .then()
                   .statusCode(200)
                   .body("Name", equalTo("Carbon credits"));

    }
    @Test
    public void validateCanRelist() {

        given()
                .when()
                .get( "/Categories/6327/Details.json?catalogue=false")
                .then()
                .statusCode(200)
                .body("CanRelist", equalTo(true));

    }
    @Test
    public void ValidateGallery() {
        String name = "Gallery";

        JsonPath jsonPath = given().when().get("/Categories/6327/Details.json?catalogue=false").jsonPath();

        Map<String, Object> promotion = jsonPath.param("name", name).get("Promotions.find { p -> p.Name == name }");

        Assert.assertNotNull(promotion);

        Assert.assertEquals(promotion.get("Description"),  "Good position in category");

    }
}
