package ru.shniros.league.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shniros.league.repository.ProductPriceRepository;
import ru.shniros.league.repository.ProductRepository;
import ru.shniros.league.response.StatisticResponse;

@RestController
@RequiredArgsConstructor
public class StatisticController {

    private final ProductPriceRepository productPriceRepository;
    private final ProductRepository productRepository;
    @GetMapping("/statistic")
    public StatisticResponse getStatistic(){

        return new StatisticResponse().setCountProduct(productRepository.countAllBy())
                                      .setCountShiftPrice(0);
        //productPriceRepository.countByDateEqualsDateAndProductEqualsProduct()
    }
}
