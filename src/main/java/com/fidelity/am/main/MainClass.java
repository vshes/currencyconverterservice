package com.fidelity.am.main;


import com.fidelity.am.api.CurrencyConverter;
import com.fidelity.am.exception.InvalidCountryException;
import com.fidelity.am.model.Country;
import com.fidelity.am.service.impl.CurrencyConverterService;

import java.util.Scanner;

public class MainClass {


    public static void main(String[] args) {


        System.out.println("Application starting ..");
        System.out.println("Enter the below details ");

        Scanner scanner = new Scanner(System.in);
        String countryName = null;
        String countryCode = "";
        String currency = "";
        int value = 0;
        System.out.println("Enter the Country information name -  [ United States, United Kingdom , European Union, India]: ");
        countryName = scanner.nextLine();
        System.out.println("Enter the Country information country code -  [ USA , UK, EU, IND]: ");
        countryCode = scanner.nextLine();
        System.out.println("Enter the Country information  currency [ USD , GBP, EURO, INR ]: ");
        currency = scanner.nextLine();
        System.out.println("Enter the value of the Change in decimal number: ");
        value = scanner.nextInt();
        scanner.close();
        System.out.println("Country Name " + countryName + "\t value entered is " + value);
        Country country = new Country(countryCode, countryName, currency);
        CurrencyConverter currencyConverter = new CurrencyConverterService();
        String response ;
        try {
            response = (String) currencyConverter.convertCurrency(country, value);
            System.out.println("\n\t" + response +"\n\t");
        } catch (InvalidCountryException e) {
            e.printStackTrace();
        }

    }
}
