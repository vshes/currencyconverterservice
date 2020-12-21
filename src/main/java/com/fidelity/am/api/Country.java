package com.fidelity.am.api;


@FunctionalInterface
public interface Country<U ,T extends String> {
     U getCountry(T t);
}
