package ru.shniros.league.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.shniros.league.domain.Product;
import ru.shniros.league.domain.ProductPrice;
import ru.shniros.league.response.ProductResponse;

@Component
public class ProductToProductResponse implements Converter<ProductPrice, ProductResponse> {

    @Override
    public ProductResponse convert(ProductPrice productPrice) {
        return new ProductResponse().setId(productPrice.getProduct().getId())
                                    .setName(productPrice.getProduct().getName())
                                    .setPrice(productPrice.getPrice())
                                    .setDate(productPrice.getDate());
    }
}
