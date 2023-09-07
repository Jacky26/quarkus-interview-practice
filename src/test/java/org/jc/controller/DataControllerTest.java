package org.jc.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jakarta.ws.rs.core.MediaType;
import org.jc.controller.response.CommonResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.smallrye.common.constraint.Assert.assertNotNull;
import static jakarta.ws.rs.core.Response.Status.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class DataControllerTest {

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    void getData_WhenFileExist_ShouldReturn200() {
        Response response = RestAssured
                .when()
                .get("/api/data/interviewFindRelationship.csv")
                .then()
                .contentType(MediaType.APPLICATION_JSON)
                .extract()
                .response();

        String status = response.getBody().as(CommonResponse.class).getStatus();
        String data = response.getBody().as(CommonResponse.class).getData().toString();
        assertEquals(String.valueOf(OK.getStatusCode()), status);
        assertNotNull(data);
    }

    @Test
    void getData_WhenFileMissing_ShouldReturn400() {
        Response response = RestAssured
                .when()
                .get("/api/data/interviewFindRelationship.xml")
                .then()
                .contentType(MediaType.APPLICATION_JSON)
                .extract()
                .response();

        String status = response.getBody().as(CommonResponse.class).getStatus();
        String data = response.getBody().as(CommonResponse.class).getData().toString();
        assertEquals(String.valueOf(BAD_REQUEST.getStatusCode()), status);
        assertNotNull(data);
    }

    @Test
    void validateData_WhenFileExist_ShouldReturn200() {
        Response response = RestAssured
                .when()
                .post("/api/data/interviewFindRelationship.csv/validate")
                .then()
                .contentType(MediaType.APPLICATION_JSON)
                .extract()
                .response();

        String status = response.getBody().as(CommonResponse.class).getStatus();
        String data = response.getBody().as(CommonResponse.class).getData().toString();
        assertEquals(String.valueOf(OK.getStatusCode()), status);
        assertNotNull(data);
    }

    @Test
    void validateData_WhenFileExist_ShouldReturn400() {
        Response response = RestAssured
                .when()
                .post("/api/data/interviewFindRelation.csv/validate")
                .then()
                .contentType(MediaType.APPLICATION_JSON)
                .extract()
                .response();

        String status = response.getBody().as(CommonResponse.class).getStatus();
        String data = response.getBody().as(CommonResponse.class).getData().toString();
        assertEquals(String.valueOf(BAD_REQUEST.getStatusCode()), status);
        assertNotNull(data);
    }

}