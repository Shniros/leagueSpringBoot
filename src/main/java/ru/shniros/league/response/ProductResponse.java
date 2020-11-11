package ru.shniros.league.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Accessors(chain = true)
public class ProductResponse {
    private Integer id;
    private String name;
    private int priceId;
    private BigDecimal price;
    private Date date;
}
