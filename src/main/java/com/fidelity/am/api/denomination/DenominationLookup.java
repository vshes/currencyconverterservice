package com.fidelity.am.api.denomination;

import java.util.List;

public interface DenominationLookup<T extends List, U extends String, V extends Number, W> {
    T getDenominationsByCountry(U u);

    T getDenominationValuesByCountry(U u);

    W getDenominationTypeByValueAndCountry(String country, V v);
}
