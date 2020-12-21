package com.fidelity.am.api.country;

import com.fidelity.am.service.config.COUNTRY_SOURCE;


public interface CountryDetails<T,U extends COUNTRY_SOURCE> {
    T getCountryData(U u);
    void configure(U u);
}
