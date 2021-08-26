package ru.shniros.league.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shniros.league.controller.dto.ProductDTO;
import ru.shniros.league.mapper.ProductMapper;
import ru.shniros.league.repository.PriceRepository;
import ru.shniros.league.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
public class ProductControllerV1 {
    private final PriceRepository priceRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping("/products")
    public List<ProductDTO> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }
}
