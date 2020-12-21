package com.fidelity.am.impl.factory;

import com.fidelity.am.service.config.FORMAT_TYPES;
import com.fidelity.am.impl.format.BasicFormatter;
import com.fidelity.am.api.FormatResponse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class FormatFactory {

    public static FormatResponse createFormatter(FORMAT_TYPES type) {
        FormatResponse formatResponse = null;
        List<FORMAT_TYPES> _valid_formats = Arrays.asList(FORMAT_TYPES.values());
        FORMAT_TYPES format_type = _valid_formats.stream().filter(x -> x.toString().equals(type.toString())).collect(Collectors.toList()).get(0);
        if(format_type !=  null){

        }
        if (type.toString().equals("BASIC")) {
            formatResponse = new BasicFormatter();
        }
        return formatResponse;
    }

}

