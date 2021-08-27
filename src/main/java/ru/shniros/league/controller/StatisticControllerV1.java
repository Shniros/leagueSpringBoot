package ru.shniros.league.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shniros.league.repository.PriceRepository;
import ru.shniros.league.repository.ProductRepository;
import ru.shniros.league.controller.dto.StatisticDTO;

@RequiredArgsConstructor
@RestController
public class StatisticControllerV1 {
    private PriceRepository priceRepository;
    private ProductRepository productRepository;

    @GetMapping("/statistic")
    public StatisticDTO getStatistic() {
        return null;
       /* return new StatisticDTO().setCountProduct(productRepository.countAllBy())
                                      .setCountShiftPrice(0);
        //productPriceRepository.countByDateEqualsDateAndProductEqualsProduct()*/
    }
}
