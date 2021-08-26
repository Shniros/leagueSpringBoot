package ru.shniros.league.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class StatisticDTO {
    private Integer countProduct;
    private Integer countShiftPrice;
    //TODO
}
