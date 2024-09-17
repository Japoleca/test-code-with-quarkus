package org.acme.service;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.acme.entity.Company;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@QuarkusTest
public class CompanyServiceTest {

    @Inject
    CompanyService service;

    private Company company;

    @BeforeEach
    public void setupTests(){
        company = new Company();
        company.setName("Test Company");
        company.setAddress("Test Address");
        company.setPhone("9283982382");
        company.setRegistry("92834342");
    }

    @Test
    @TestTransaction
    public void testSaveCompany() {
        Assertions.assertEquals(Optional.of(company), service.saveCompany(company));
    }

    @Test
    @TestTransaction
    public void testErrorSaveCompany() {
        Assertions.assertEquals(Optional.empty(), service.saveCompany(null));
    }

    @Test
    @TestTransaction
    public void testGetCompany() {

        service.saveCompany(company);

        List<Company> companies = new ArrayList<>();
        companies.add(company);

        Optional<List<Company>> expected = Optional.of(companies);
        Optional<List<Company>> actual = service.getCompanies();

        Assertions.assertEquals(expected, actual);
    }
}
