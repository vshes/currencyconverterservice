package com.fidelity.am.impl.factory;

import com.fidelity.am.api.country.CountryLookup;
import com.fidelity.am.api.country.CountryLookupByCode;
import com.fidelity.am.api.country.CountryLookupByCurrency;
import com.fidelity.am.impl.factory.gen.CountryLookupTable;

public final class StaticCountryFactory implements CountryLookupByCurrency, CountryLookupByCode, CountryLookup {
    @Override
    public Object getCountryByCode(String countryCode) {
        return  CountryLookupTable.getByCountryCode(countryCode);
    }

    @Override
    public Object getCountryByCurrency(String currency) {
        return CountryLookupTable.getByCurrency(currency);
    }

    @Override
    public Object getCountryByName(String name) {
        return CountryLookupTable.getByCountryName(name);
    }


    public static StaticCountryFactory create(){
        return new StaticCountryFactory();
    }
}
