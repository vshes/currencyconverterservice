package com.fidelity.am.api.country;

import com.fidelity.am.api.Country;

@FunctionalInterface
public interface CountryLookup<T>
{
     T getCountryByName(String name);
}
