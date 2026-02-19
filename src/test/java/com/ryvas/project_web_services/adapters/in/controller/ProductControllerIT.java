package com.ryvas.project_web_services.adapters.in.controller;

import com.ryvas.project_web_services.adapters.in.dto.ProductDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerIT {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void createProduct() {
        ProductDto json = new ProductDto(
                "Monitor Samsung",
                "Monitor 4K, 144Hz",
                3000.90,
                "",
                Set.of(1, 3)
        );
        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("/products")
                .then()
                .statusCode(201);
    }

    @Test
    public void getAllProducts() {
        given()
                .when()
                .get("/products")
                .then()
                .statusCode(200);
    }
    @Test
    public void getByIdProducts() {
        given()
                .when()
                .get("/products/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1));
    }
}
