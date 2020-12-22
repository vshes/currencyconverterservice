package com.fidelity.am.service.impl;

import com.fidelity.am.exception.InvalidCountryException;
import com.fidelity.am.model.Country;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("Currency Conversion Test Class")
class CurrencyConverterServiceTest {
    public CurrencyConverterServiceTest() {
    }

    @ParameterizedTest(name = "#{index} {0} {1}")
    @MethodSource("argumentProvider")
    void test_conversions_ok(Country country, int val) {
        CurrencyConverterService currencyConverterService = new CurrencyConverterService();
        System.out.println(country.toString());
        try {
            String response = currencyConverterService.convertCurrency(country,val);
            
        } catch (InvalidCountryException e) {
            e.printStackTrace();
        }

    }

    @Test
    void test_one(){

    }
    @MethodSource("newArg")
    @ParameterizedTest(name = "#{index} {0} {1}")
    void test_cli_ok(String country, int val) {

    }

    static Stream<Arguments> argumentProvider() {

        return Stream.of(
                arguments(new Country("USA","United States of America", "USD"), 2334566),
                arguments(new Country("UK","United Kingdom", "GBP"), 21334566),
                arguments(new Country("IND","India", "INR"), 5)
        );
    }

    static Stream<Arguments> newArg() {

        return Stream.of(
                arguments("test 0", 1),
                arguments("test 1", 2)
        );
    }

}