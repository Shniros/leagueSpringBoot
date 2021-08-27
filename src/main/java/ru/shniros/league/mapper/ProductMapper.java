package ru.shniros.league.mapper;

import org.mapstruct.Mapper;
import ru.shniros.league.controller.dto.ProductDTO;
import ru.shniros.league.repository.domain.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductDTO productDTO);

    ProductDTO toProductDTO(Product product);
}
