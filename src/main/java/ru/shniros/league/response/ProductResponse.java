package ru.shniros.league.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductResponse {
    private Integer id;
    private String name;
    private  double price;
    private String date;
}
