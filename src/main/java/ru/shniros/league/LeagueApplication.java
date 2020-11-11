package ru.shniros.league;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.shniros.league.csv.ImportCSV;
import ru.shniros.league.repository.ProductPriceRepository;
import ru.shniros.league.repository.ProductRepository;


@SpringBootApplication
public class LeagueApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(LeagueApplication.class, args);
    }

    /*@Autowired
    ProductPriceRepository productPriceRepository;
    @Autowired
    ProductRepository productRepository;*/
    @Autowired
    ImportCSV importCSV;
    @Override
    public void run(String... args) {
        importCSV.startImport();
    }
}
