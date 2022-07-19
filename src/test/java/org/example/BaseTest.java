package org.example;

import io.restassured.RestAssured;
import org.junit.Before;

public class BaseTest {
    @Before
    public void setup() {
        RestAssured.baseURI = "https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false";
    }
}