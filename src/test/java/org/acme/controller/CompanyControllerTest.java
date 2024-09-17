package org.acme.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.acme.entity.Company;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;

@QuarkusTest
public class CompanyControllerTest {

    @Test
    public void testSaveCompanyEndPoint() throws Exception {

        Company company = new Company();
        company.setName("Test Company");
        company.setAddress("Test Address");
        company.setPhone("9283982382");
        company.setRegistry("92834342");

        RestAssured
                .given()
                .contentType("application/json")
                .body(company)
                .when()
                .post("/company")
                .then()
                .statusCode(200)
                .body("name", equalTo("Test Company"))
                .body("address", equalTo("Test Address"))
                .body("phone", equalTo("9283982382"))
                .body("registry", equalTo("92834342"));
    }

    @Test
    public void testFindAllCompaniesEndPoint() throws Exception {
        RestAssured
                .when()
                .get("/company")
                .then()
                .statusCode(200)
                .body("size()", greaterThanOrEqualTo(0));
    }
}
