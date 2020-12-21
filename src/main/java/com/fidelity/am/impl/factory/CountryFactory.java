package com.fidelity.am.impl.factory;

import com.fidelity.am.model.Country;
import com.fidelity.am.service.config.COUNTRY_CODE;
import com.fidelity.am.impl.factory.gen.CountryLookupTable;

import java.util.Optional;

public class CountryFactory  implements com.fidelity.am.api.Country {

    static  Country country ;

    public static Country build(String code) {
         country = CountryLookupTable.getByCountryCode(code);
        return country;
    }
    public static Country countryByCurrency(String currency) {
        country = CountryLookupTable.getByCurrency(currency);
        return country;
    }


    @Override
    public Country getCountry(String country) {
        Optional<COUNTRY_CODE> countryCodeOptional = Optional.ofNullable(COUNTRY_CODE.valueOf(country));
        if(countryCodeOptional.isPresent()){
         return   CountryLookupTable.getByCountryCode(country);
        }
        else{
            return CountryLookupTable.getByCountryName(country.toString());

        }

    }
}
