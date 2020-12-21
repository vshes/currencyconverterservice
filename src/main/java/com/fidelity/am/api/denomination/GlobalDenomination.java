package com.fidelity.am.api.denomination;

public interface GlobalDenomination<T,U> {
    T getDenomination();
    T configure(U source);
}
