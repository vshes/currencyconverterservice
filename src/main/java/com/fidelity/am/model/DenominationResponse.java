package com.fidelity.am.model;

public class DenominationResponse {

    private int count;
    private  Denomination denomination;

    public int getCount() {
        return count;
    }

    public DenominationResponse() {
    }

    public DenominationResponse(int count, Denomination denomination) {
        this.count = count;
        this.denomination = denomination;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public void setDenomination(Denomination denomination) {
        this.denomination = denomination;
    }

}
