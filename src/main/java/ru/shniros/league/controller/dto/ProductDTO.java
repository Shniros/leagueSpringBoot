package ru.shniros.league.controller.dto;

import lombok.experimental.Accessors;

import java.util.Date;

@Accessors(chain = true)
public class ProductDTO {
    private Integer id;
    private String name;
    private long price;
    private Date date;
}
