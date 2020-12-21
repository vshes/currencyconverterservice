package com.fidelity.am.impl.factory.gen;

import com.fidelity.am.model.Denomination;
import com.fidelity.am.service.config.COUNTRY_CODE;
import com.fidelity.am.service.config.COUNTRY_NAME;
import com.fidelity.am.service.config.CURRENCY;

import java.util.*;
import java.util.stream.Collectors;

public final class DenominationGenerator {

    static Map<COUNTRY_CODE, List<Denomination>> denominationMap = new HashMap<>();
    static Map<COUNTRY_NAME, List<Denomination>> denominationCountryNameMap = new HashMap<>();
    static Map<CURRENCY, List<Denomination>> denominationCountryCurrencyMap = new HashMap<>();

    static {
        List<Denomination> denominations = new ArrayList<>();
        denominations.add(new Denomination(1, "1 cent"));
        denominations.add(new Denomination(5, "5 cents"));
        denominations.add(new Denomination(10, "Dime"));
        denominations.add(new Denomination(25, "Quarter"));
        denominations.add(new Denomination(100, "Dollar "));
        denominations.add(new Denomination(500, " 5 Dollar bill"));
        denominations.add(new Denomination(1000, "10 Dollar bill"));
        denominations.add(new Denomination(2000, "20 Dollar bill"));
        denominations.add(new Denomination(5000, "50 dollar bill"));
        denominations.add(new Denomination(10000, "100 Dollars Bill"));
        denominationMap.put(COUNTRY_CODE.USA, denominations);
        denominations = new ArrayList<>();
        denominations.add(new Denomination(1, "1p"));
        denominations.add(new Denomination(5, "5c"));
        denominations.add(new Denomination(10, "10c"));
        denominations.add(new Denomination(20, "20c"));
        denominations.add(new Denomination(100, "1 Pound"));
        denominations.add(new Denomination(1000, "10 pounds"));
        denominations.add(new Denomination(2000, "20 pounds"));
        denominations.add(new Denomination(5000, "50 pounds"));
        denominationMap.put(COUNTRY_CODE.UK, denominations);
        denominations = new ArrayList<>();
        denominations.add(new Denomination(1, "1 paise"));
        denominations.add(new Denomination(5, "5 paise"));
        denominations.add(new Denomination(10, "10 pasie"));
        denominations.add(new Denomination(20, "20 paise"));
        denominations.add(new Denomination(25, "25 paise"));
        denominations.add(new Denomination(50, "50 paise"));
        denominations.add(new Denomination(100, "1 Rupee"));
        denominations.add(new Denomination(200, "2 Rupees"));
        denominations.add(new Denomination(500, "5 Rupees"));
        denominations.add(new Denomination(1000, "10 Rupees"));
        denominations.add(new Denomination(2000, "20 Rupees"));
        denominations.add(new Denomination(5000, "50 Rupees"));
        denominations.add(new Denomination(10000, "100 Rupees"));
        denominations.add(new Denomination(500000, "500 Rupees"));
        denominations.add(new Denomination(1000000, "1000 Rupees"));
        denominations.add(new Denomination(2000000, "2000 Rupees"));
        denominationMap.put(COUNTRY_CODE.IND, denominations);
    }

    public static List<Denomination> getDenominationByCountry(String code) {
        List<COUNTRY_CODE> codes = Arrays.stream(COUNTRY_CODE.values()).sorted().collect(Collectors.toList());
        codes.forEach(x -> System.out.println(x));
        System.out.println(denominationMap.get(COUNTRY_CODE.valueOf(code)));
        return denominationMap.get(COUNTRY_CODE.valueOf(code));
    }

    public static List<Integer> getAllDenominationValues(String countryCode) {

        List<Integer> values = denominationMap
                .get(COUNTRY_CODE.valueOf(countryCode))
                .stream()
                .map(x -> x.getValue()).
                        sorted((x1, x2) -> x2.intValue() - x1.intValue())
                .collect(Collectors.toList());
        return values;
    }

    public static Denomination getDenominationObject(int value, String countryCode) {

        Denomination denomination = denominationMap
                .get(COUNTRY_CODE.valueOf(countryCode))
                .stream()
                .filter(x -> x.getValue() == value)
                .collect(Collectors.toList())
                .get(0);
        return denomination;
    }


}