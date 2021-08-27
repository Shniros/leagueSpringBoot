package ru.shniros.league.repository.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Accessors(chain = true)
@RequiredArgsConstructor
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private long cost;
    @Column
    private Date date;
    @ManyToOne
    @JoinColumn
    private Product product;
}
