package ru.shniros.league.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.shniros.league.converter.ToProductResponse;
import ru.shniros.league.csv.ImportCSV;
import ru.shniros.league.domain.Product;
import ru.shniros.league.domain.ProductPrice;
import ru.shniros.league.repository.ProductPriceRepository;
import ru.shniros.league.repository.ProductRepository;
import ru.shniros.league.response.ProductResponse;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductPriceRepository productPriceRepository;
    private final ToProductResponse converter;
    private final ProductRepository productRepository;

    @GetMapping("/products")
    public List<ProductResponse> getProducts(){
        return productPriceRepository.findAll().stream().map(converter::convert).collect(toList());
    }
    @GetMapping("/products/{date}")
    public ResponseEntity<List<ProductResponse>> getProducts(@PathVariable("date") String date){
        List<ProductPrice> byDate = productPriceRepository.findByDate(ImportCSV.sdfParser(date));
        if(byDate == null){
            return notFound().build();
        }
        return ok(byDate.stream().map(converter::convert).collect(toList()));
    }
    //нижнее использовал для тестов, вроде по ТЗ должно хватить того что сверху
   /* @GetMapping("/products/{productName}")
    public ResponseEntity<List<ProductResponse>>  getProductByName(@PathVariable("productName") String productName){
        Product product =  productRepository.findByName(productName);
        List<ProductPrice> byProduct = productPriceRepository.findByProduct(product);
        if(product == null || byProduct == null) {
            return notFound().build();
        }
       return ok(byProduct.stream().map(converter::convert).collect(toList()));
    }
    @GetMapping("/products/{productName}/{priceDate}")
    public ResponseEntity<List<ProductResponse>>   getProductByDate(@PathVariable("productName") String productName,
                                                             @PathVariable("priceDate") String priceDate)
    {
        Product product =  productRepository.findByName(productName);
        List<ProductPrice> byProductAndDate = productPriceRepository.findByProductAndDate(product,ImportCSV.sdfParser(priceDate));

        if(product == null || byProductAndDate == null) {
            return notFound().build();
        }
        return ok(byProductAndDate.stream().map(converter::convert).collect(toList()));
    }*/

}
