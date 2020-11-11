package ru.shniros.league.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shniros.league.repository.ProductPriceRepository;
import ru.shniros.league.repository.ProductRepository;
import ru.shniros.league.response.StatisticResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StatisticController {

    private final ProductPriceRepository productPriceRepository;
    private final ProductRepository productRepository;
    @GetMapping("/products/statistic")
    public StatisticResponse getStatistic(){
        StatisticResponse response = new StatisticResponse();
        List<Thread> listThreads = new ArrayList<>();
        //хз можно так или это дурной вкус. При помощи лямбда выражений создаю лист thread'ов
        listThreads.add(new Thread(() ->  response.setCountProduct(productRepository.countAllBy())));
        listThreads.add(new Thread(() -> response.setCountShiftPrice(productPriceRepository.countByShiftChanges())));
        //запускаю созданные потоки
        for(Thread thread:listThreads){
            thread.start();
        }
        //ожидаю пока все потоки завершатся
        boolean lastThread;
        do{
            lastThread = false;
            for (Thread thread:listThreads){
                if(thread.isAlive())
                        lastThread = true;
            }

        }while (lastThread);

        return response;
    }
}
