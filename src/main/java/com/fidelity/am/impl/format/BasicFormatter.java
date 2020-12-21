package com.fidelity.am.impl.format;

import com.fidelity.am.api.FormatResponse;
import com.fidelity.am.model.DenominationResponse;

import java.util.List;

public class BasicFormatter implements FormatResponse {


    @Override
    public String currencyFormat(List list,Object value) {
        StringBuilder stringBuilder = new StringBuilder();
        validateResponse(list, (int)value, stringBuilder);
        return stringBuilder.toString();
    }

    private void validateResponse(List list, int value, StringBuilder stringBuilder) {
        if(value > 0){
            stringBuilder.append("Given the balance " + value).
                    append(", the function will return ");
            list.forEach(x -> {
                stringBuilder.append(((DenominationResponse) x).getCount()).
                        append(" ")
                        .append(((DenominationResponse) x).getDenomination().getDescription())
                        .append(", ");
            });

            int lastIndex = stringBuilder.toString().lastIndexOf(",");
            if (lastIndex > 0)
                stringBuilder.replace(lastIndex, lastIndex + 1, ".");
            lastIndex = stringBuilder.toString().lastIndexOf(",");
            if (lastIndex > 0)
                stringBuilder.replace(lastIndex, lastIndex + 1, " and ");
        }
    }
}
