package org.acme.service;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class MyUtilsServiceTest {
    @Inject
    MyUtilsService service;

    @Test
    public void testPrimeNumberValidation() {
        Assertions.assertTrue(service.isPrimeNumber(5));
        Assertions.assertFalse(service.isPrimeNumber(0));
    }

    @Test
    public void testTextSizeValidation() {
        Assertions.assertEquals(19, service.countCharacters("Testing this method"));
        Assertions.assertEquals(7, service.countCharacters("Testing"));
    }
}

