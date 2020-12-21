package com.fidelity.am.impl.factory.gen;

import com.fidelity.am.model.Country;

import java.util.HashMap;
import java.util.Map;

public final  class CountryLookupTable {
    private static Map<String, Country> countryMap = new HashMap<>();
    private static Map<String, Country> countryCurrencyMap = new HashMap<>();
    private static Map<String, Country> countryNameMap = new HashMap<>();

    static {
        countryMap.put("USA", new Country("USA", "United States of America", "USD"));
        countryMap.put("UK", new Country("UK", "United Kingdom", "GBP"));
        countryMap.put("IND", new Country("IND", "INDIA", "INR"));
        countryMap.put("EU", new Country("EU", "European Union", "Euro"));
        countryMap.put("CAN", new Country("CAN", "CANADA", "CAD"));
        countryMap.put("UK", new Country("UK", "United Kingdom", "GBP"));
        countryCurrencyMap.put("INR", new Country("IND", "INDIA", "INR"));
        countryCurrencyMap.put("GBP", new Country("UK", "United Kingdom", "GBP"));
        countryCurrencyMap.put("EURO", new Country("EU", "European Union", "Euro"));
        countryCurrencyMap.put("CAD", new Country("CAN", "CANADA", "CAD"));
        countryCurrencyMap.put("USD", new Country("USA", "United States of America", "USD"));
        countryCurrencyMap.put("INR", new Country("IND", "INDIA", "INR"));
        countryNameMap.put("UNITED KINGDOM", new Country("UK", "United Kingdom", "GBP"));
        countryNameMap.put("EUROPEAN UNION", new Country("EU", "European Union", "Euro"));
        countryNameMap.put("INDIA", new Country("IND", "INDIA", "INR"));
        countryNameMap.put("CANADA", new Country("CAN", "CANADA", "CAD"));
        countryNameMap.put("UNITED STATES OF AMERICA", new Country("USA", "United States of America", "USD"));
    }

    public static Country getByCountryCode(String code) {
        return countryMap.get(code);
    }

    public static Country getByCurrency(String currency) {
        return countryCurrencyMap.get(currency);
    }

    public static Country getByCountryName(String toString) {
        return countryNameMap.get(toString);
    }

    public static boolean validate(Country country) {
        boolean flag = false;
        if (!countryMap.containsKey(country.getCountryCode().toUpperCase())) {
            flag = true;
        }
        if (!countryNameMap.containsKey(country.getName().toUpperCase())) {
            flag = true;
        }
        if (!countryCurrencyMap.containsKey(country.getCurrency().toUpperCase())) {
            flag = true;
        }
        return flag;
    }
}
