package com.fidelity.am.api;

import java.util.List;

@FunctionalInterface
public interface FormatResponse<T,U extends List,V> {

    T currencyFormat(U u,V v);
}
