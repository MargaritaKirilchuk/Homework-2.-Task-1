package ru.netology.rest;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

class MobileBankApiTestV5 {
    @Test
    void shouldReturnDemoAccounts() {
      given()
          .baseUri("http://localhost:7777/api/v1")
      .when()
          .get("/demo/accounts")
      .then()
          .statusCode(200)
          .contentType(ContentType.JSON)
          .body("every{ it.balance >= 0 }", is(true))
      ;
    }
}
