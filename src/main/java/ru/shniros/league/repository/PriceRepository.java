package ru.shniros.league.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shniros.league.repository.domain.Product;
import ru.shniros.league.repository.domain.Price;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Integer> {
    List<Price> findByProductAndDate(Product product, String priceDate);
    List<Price> findByProduct(Product product);
    List<Price> findByDate(String date);
}
