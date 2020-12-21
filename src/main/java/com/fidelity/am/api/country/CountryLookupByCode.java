package com.fidelity.am.api.country;

import com.fidelity.am.api.Country;

@FunctionalInterface
public interface CountryLookupByCode<T> {
    T getCountryByCode(String countryCode);
}
