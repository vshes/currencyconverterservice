package com.fidelity.am.api;

import com.fidelity.am.api.model.Country;

@FunctionalInterface
public interface CurrencyConverter<S extends FormatResponse,T extends Country,U extends Number> {
     S convertCurrency( T country, U value);
}
