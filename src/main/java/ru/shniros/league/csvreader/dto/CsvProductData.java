package ru.shniros.league.csvreader.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class CsvProductData {
    @CsvBindByPosition(position = 0)
    private Integer productId;
    @CsvBindByPosition(position = 1)
    private String productName;
    @CsvBindByPosition(position = 2)
    private Integer priceId;
    @CsvBindByPosition(position = 3)
    private double price;
    @CsvBindByPosition(position = 4)
    private String priceDate;
}
