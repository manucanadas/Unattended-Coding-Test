package org.example;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class CategoriesDetailsTest extends BaseTest {
    @Test
    public void validateExactName() {
        String expectedName = "Carbon credits";

        getCategoryDetail()
                .then()
                .body("Name", equalTo(expectedName));
    }

    @Test
    public void validateCanRelist() {
        getCategoryDetail()
                .then()
                .body("CanRelist", equalTo(true));
    }

    @Test
    public void ValidatePromotionWithNameGalleryHasCorrectDescription() {
        String name = "Gallery";
        String expectedDescription = "Good position in category";

        JsonPath jsonPath = getCategoryDetail().jsonPath();
        Map<String, Object> promotion = jsonPath.param("name", name).get("Promotions.find { promotion -> promotion.Name == name }");

        Assert.assertNotNull(promotion);
        Assert.assertEquals(promotion.get("Description"), expectedDescription);
    }

    private Response getCategoryDetail() {
        return given()
                .when()
                .get(TestPathUtil.getCategoryPath(6327));
    }
}
