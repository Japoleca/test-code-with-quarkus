package org.acme.service;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.acme.util.CalcUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@QuarkusTest
public class MyUtilsServiceMockTest {

    @InjectMocks
    private MyUtilsService myUtilsService;

    @Mock
    private CalcUtils calcUtilsMock;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testVerifyPrimeNumberWithMocks(){

        when(calcUtilsMock.verifyPrimeNumber(5)).thenReturn(true);
        when(calcUtilsMock.verifyPrimeNumber(0)).thenReturn(false);

        boolean result1 = myUtilsService.isPrimeNumber(5);
        boolean result2 = myUtilsService.isPrimeNumber(0);

        assertEquals(true, result1);
        assertEquals(false, result2);

    }

}
