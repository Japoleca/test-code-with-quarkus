package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.util.CalcUtils;


@ApplicationScoped
public class MyUtilsService {

    @Inject
    CalcUtils calcUtils;

    public boolean isPrimeNumber(int number) {

        return calcUtils.verifyPrimeNumber(number);

    }

    public int countCharacters(String input){
        return input.length();
    }
}
