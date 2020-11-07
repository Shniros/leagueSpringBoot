package ru.shniros.league.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shniros.league.domain.Product;


public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
    Integer countAllBy();
}
