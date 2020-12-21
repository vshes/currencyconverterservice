package com.fidelity.am.service.config;

import java.util.HashMap;
import java.util.Map;

public enum COUNTRY_CODE {

    USA("United States of America","USA"),
    UK(" United Kingdom","UK"),
    IND("India","IND");

    private static final Map<String, String> _COUNTRY_CODE_NAMES = new HashMap<>();

    static {
        for( COUNTRY_CODE codes : values()){
            _COUNTRY_CODE_NAMES.put(codes.code,codes.name);
        }
    }


    private String name;
    private String code;

    COUNTRY_CODE(String name,String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static String getCountry(String code){
        return _COUNTRY_CODE_NAMES.get(code);
    }
}
