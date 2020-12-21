package com.fidelity.am.impl.factory;

import com.fidelity.am.api.denomination.DenominationLookup;
import com.fidelity.am.model.Denomination;
import com.fidelity.am.impl.factory.gen.DenominationGenerator;

import java.util.List;

public class StaticDenominationFactory implements DenominationLookup {

    @Override
    public List getDenominationsByCountry(String s) {
        return (List<Denomination>)DenominationGenerator.getDenominationByCountry(s);
    }

    @Override
    public List getDenominationValuesByCountry(String s) {
        return (List<Integer>)DenominationGenerator.getAllDenominationValues(s);
    }

    @Override
    public Object getDenominationTypeByValueAndCountry(String country, Number number) {
        return (Denomination)DenominationGenerator.getDenominationObject((Integer) number,country);
    }



}
