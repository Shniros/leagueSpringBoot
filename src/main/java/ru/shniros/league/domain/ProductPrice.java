package ru.shniros.league.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Accessors(chain = true)
@RequiredArgsConstructor
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "price")
    private double price;
    @Column(name = "date")
    private String date; //не знаю в каком у вас формате дата поэтому решил использовать string
    @ManyToOne
    @JoinColumn
    private Product product;
}
