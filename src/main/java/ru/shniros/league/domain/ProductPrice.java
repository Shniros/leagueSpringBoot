package ru.shniros.league.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Accessors(chain = true)
@RequiredArgsConstructor
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "date")
    private Date date;
    @ManyToOne
    @JoinColumn
    private Product product;
}
