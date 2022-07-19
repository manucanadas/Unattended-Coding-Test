package org.example;

import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UnattendedCodingTest extends BaseTest {

    @Test
    public void validateName() {

        given()
                .when()
                   .get("/Categories/6327/Details.json?catalogue=false")
                .then()
                   //.log().all()
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

        given()
                .when()
                .get("/Categories/6327/Details.json?catalogue=false")
                .then()
                .statusCode(200)
                .body("Promotions[1].Description", equalTo("Good position in category"));

    }
}
