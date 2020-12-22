package com.fidelity.am.main;


import com.fidelity.am.api.CurrencyConverter;
import com.fidelity.am.exception.InvalidCountryException;
import com.fidelity.am.model.Country;
import com.fidelity.am.service.impl.CurrencyConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MainClass {


    private static Logger logger = LoggerFactory.getLogger(MainClass.class);

    public static void main(String[] args) {

        logger.info("Application starting ...");
        Scanner scanner = new Scanner(System.in);
        String countryName = null;
        String countryCode = "";
        String currency = "";
        int value = 0;
        logger.info("Enter the Country information name - [ United States, United Kingdom , European Union, India]: \n");
        countryName = scanner.nextLine();
        logger.info("Enter the Country information country code -  [ USA , UK, EU, IND]: \n");
        countryCode = scanner.nextLine();
        logger.info("Enter the Country information  currency [ USD , GBP, EURO, INR ]: \n");
        currency = scanner.nextLine();
        logger.info("Enter the value of the Change in decimal number: \n");
        value = scanner.nextInt();
        scanner.close();
        logger.info("Country Name " + countryName + "\t value entered is " + value);
        Country country = new Country(countryCode, countryName, currency);
        CurrencyConverter currencyConverter = new CurrencyConverterService();
        String response;
        try {
            response = (String) currencyConverter.convertCurrency(country, value);
            logger.info("\n\t" + response + "\n\t");
        } catch (InvalidCountryException e) {
            e.printStackTrace();
        }
        logger.info("Application completed");
        logger.info("************************");

    }
}
