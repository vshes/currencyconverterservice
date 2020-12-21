package com.fidelity.am.impl.factory.gen;

import com.fidelity.am.api.model.Country;

import java.util.HashMap;
import java.util.Map;

public class CountryLookupTable  {
    private static Map<String, Country> countryMap = new HashMap<>();
    private static Map<String, Country> countryCurrencyMap = new HashMap<>();
    private static Map<String, Country> countryNameMap = new HashMap<>();

    static {
        countryMap.put("USA", new Country("USA", "United States of America", "USD"));
        countryMap.put("UK", new Country("UK", "United Kingdom", "GBP"));
        countryMap.put("IND", new Country("IND", "United States of America", "USD"));
        countryMap.put("EU", new Country("EU", "United States of America", "USD"));
        countryMap.put("CAN", new Country("CAN", "United States of America", "USD"));
        countryCurrencyMap.put("USD", new Country("USA", "United States of America", "USD"));
        countryNameMap.put("United States of America", new Country("USA", "United States of America", "USD"));
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
}
