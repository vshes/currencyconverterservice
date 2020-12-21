package com.fidelity.am.api.country;

@FunctionalInterface
public interface CountryLookupByCurrency<T> {
    T getCountryByCurrency(String currency);
}
