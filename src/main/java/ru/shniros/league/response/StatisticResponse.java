package ru.shniros.league.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class StatisticResponse {
    private Integer countProduct;
    private Integer countShiftPrice;
    //TODO
}
