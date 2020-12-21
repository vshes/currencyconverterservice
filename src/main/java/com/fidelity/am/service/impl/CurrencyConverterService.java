package com.fidelity.am.service.impl;

import com.fidelity.am.api.CurrencyConverter;
import com.fidelity.am.api.FormatResponse;
import com.fidelity.am.api.denomination.DenominationLookup;
import com.fidelity.am.model.Country;
import com.fidelity.am.model.DenominationResponse;
import com.fidelity.am.exception.InvalidCountryException;
import com.fidelity.am.impl.factory.DenominationFactory;
import com.fidelity.am.impl.factory.FormatFactory;
import com.fidelity.am.impl.factory.gen.CountryLookupTable;
import com.fidelity.am.impl.factory.gen.DenominationGenerator;
import com.fidelity.am.service.config.DENOMINATIONTYPE;
import com.fidelity.am.service.config.FORMAT_TYPES;

import java.util.ArrayList;
import java.util.List;

public class CurrencyConverterService implements CurrencyConverter {


    @Override
    public String convertCurrency(Country country, Number value) throws InvalidCountryException {
        DenominationLookup lookup = DenominationFactory.build(DENOMINATIONTYPE.STATIC);
        if(CountryLookupTable.validate(country)){
            throw new InvalidCountryException("Country Name, Country Code and Currency must be valid");
        }

        FormatResponse formatResponse = FormatFactory.createFormatter(FORMAT_TYPES.BASIC);
        String response = (String) formatResponse.currencyFormat(compute((int) value, lookup.getDenominationValuesByCountry(country.getCountryCode()), country.getCountryCode()), value);
        return response;
    }

    private static List<DenominationResponse> compute(int value, List<Integer> denominations, String countryCode) {
        List<DenominationResponse> response = new ArrayList<>();
        int x = value;
        while (x != 0) {

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
