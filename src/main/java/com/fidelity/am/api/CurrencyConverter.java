package com.fidelity.am.api;

import com.fidelity.am.model.Country;
import com.fidelity.am.exception.InvalidCountryException;

@FunctionalInterface
public interface CurrencyConverter<S, T extends Country, U extends Number> {
    S convertCurrency(T country, U value) throws InvalidCountryException;
}
