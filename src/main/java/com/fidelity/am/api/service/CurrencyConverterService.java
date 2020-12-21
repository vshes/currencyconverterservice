package com.fidelity.am.api.service;

import com.fidelity.am.api.CurrencyConverter;
import com.fidelity.am.api.FormatResponse;
import com.fidelity.am.api.denomination.DenominationLookup;
import com.fidelity.am.api.model.Country;
import com.fidelity.am.api.model.Denomination;
import com.fidelity.am.api.model.DenominationResponse;
import com.fidelity.am.impl.factory.DenominationFactory;
import com.fidelity.am.impl.factory.FormatFactory;
import com.fidelity.am.impl.factory.gen.DenominationGenerator;
import com.fidelity.am.impl.format.BasicFormatter;
import com.fidelity.am.service.config.DENOMINATIONTYPE;
import com.fidelity.am.service.config.FORMAT_TYPES;

import java.util.ArrayList;
import java.util.List;

public class CurrencyConverterService implements CurrencyConverter {

    public void init() {

    }


    @Override
    public FormatResponse convertCurrency(Country country, Number value) {
        DenominationLookup lookup = DenominationFactory.build(DENOMINATIONTYPE.STATIC);
        lookup.getDenominationValuesByCountry(country.getCountryCode());
        List<Denomination> denominationList = DenominationLookupService.denominationsByCountry(country.getCountryCode());
        System.out.println(denominationList);
        FormatResponse formatResponse = FormatFactory.createFormatter(FORMAT_TYPES.BASIC);
        String res = (String) formatResponse.currencyFormat(compute((int)value,lookup.getDenominationValuesByCountry(country.getCountryCode()),country.getCountryCode()),value);
        return formatResponse;
    }

    public static void main(String[] args) {
        Country country = new Country("USA", "United States of America", "USD");
        CurrencyConverterService currencyConverterService = new CurrencyConverterService();
        currencyConverterService.convertCurrency(country, 1200032);

    }

    private static List<DenominationResponse> compute(int value, List<Integer> denominations, String countryCode) {

        List<DenominationResponse> response = new ArrayList<>();
        int x = value;
        while (x != 0) {
            if (x == 0) break;
            for (int i = 0; i < denominations.size(); i++) {
                if (denominations.get(i) <= x) {
                    int count = Math.floorDiv(x, denominations.get(i));
                    x = Math.floorMod(x, denominations.get(i));
                    DenominationResponse denominationResponse = new DenominationResponse();
                    denominationResponse.setCount(count);
                    denominationResponse.setDenomination(DenominationGenerator.getDenominationObject(denominations.get(i), countryCode));
                    response.add(denominationResponse);
                    if (x == 0) {
                        break;
                    }
                }

            }
        }
        return response;
    }

}
