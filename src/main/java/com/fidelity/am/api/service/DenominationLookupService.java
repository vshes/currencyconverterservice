package com.fidelity.am.api.service;

import com.fidelity.am.api.model.Denomination;
import com.fidelity.am.impl.factory.gen.DenominationGenerator;

import java.util.List;

public class DenominationLookupService {

    public static List<Denomination> denominationsByCountry(String code) {

        List<Integer> vals = DenominationGenerator.getAllDenominationValues(code);

        vals.forEach( x-> {
            System.out.println(DenominationGenerator.getDenominationObject(x, code));
        } );

        return DenominationGenerator.getDenominationByCountry(code);
    }


}
