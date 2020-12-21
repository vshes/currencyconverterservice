package com.fidelity.am.impl.factory;

import com.fidelity.am.api.denomination.DenominationLookup;
import com.fidelity.am.service.config.DENOMINATIONTYPE;


public class DenominationFactory {

    private static DenominationLookup denominationLookup;

    public static DenominationLookup build(DENOMINATIONTYPE denominationtype) {

        if (denominationtype.equals(DENOMINATIONTYPE.STATIC)) {
            denominationLookup = new StaticDenominationFactory();
        }
        return denominationLookup;
    }


}
