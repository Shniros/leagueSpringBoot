package ru.shniros.league.repository;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.shniros.league.domain.Product;
import ru.shniros.league.domain.ProductPrice;

import java.util.List;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Integer> {
    List<ProductPrice> findByProductAndDate(Product product,String priceDate);
    List<ProductPrice> findByProduct(Product product);
    List<ProductPrice> findByDate(String date);
    //Integer countByDateEqualsDateAndProductEqualsProduct();
}
