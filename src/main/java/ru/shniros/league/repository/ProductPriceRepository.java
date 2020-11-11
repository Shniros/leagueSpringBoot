package ru.shniros.league.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.shniros.league.domain.Product;
import ru.shniros.league.domain.ProductPrice;

import java.util.Date;
import java.util.List;
@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Integer> {
    List<ProductPrice> findByProductAndDate(Product product, Date priceDate);
    List<ProductPrice> findByProduct(Product product);
    List<ProductPrice> findByDate(Date date);

    //показывает количество измененных цена за последние сутки
    @Query(value = "SELECT count(a.date) FROM league.product_price a" +
                   " WHERE a.date >= now() - (interval '1 day')", nativeQuery = true)
    Integer countByShiftChanges();
    
}
