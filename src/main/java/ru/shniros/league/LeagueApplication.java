package ru.shniros.league;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.shniros.league.csvreader.SmartCsvReader;
import ru.shniros.league.csvreader.dto.CsvProductData;
import ru.shniros.league.domain.Product;
import ru.shniros.league.domain.ProductPrice;
import ru.shniros.league.repository.ProductPriceRepository;
import ru.shniros.league.repository.ProductRepository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.Arrays.asList;

@SpringBootApplication
public class LeagueApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LeagueApplication.class, args);
    }
    private static final Logger logger = Logger.getLogger(LeagueApplication.class.getName());
    @Autowired
    ProductPriceRepository productPriceRepository;
    @Autowired
    ProductRepository productRepository;
    @Override
    public void run(String... args) {
        //читаем csv- файл
        //<- path.properties кидаем туда путь к csv файлу

        SmartCsvReader reader = new SmartCsvReader();
        List<CsvProductData> csvProductDataList = null;
        try {
            csvProductDataList = reader.readCsvFile();
            logger.log(Level.INFO,"Start import");
            for(CsvProductData data:csvProductDataList){
                Product product = new Product()
                        .setId(data.getProductId())
                        .setName(data.getProductName());
                ProductPrice productPrice = new ProductPrice()
                        .setId(data.getPriceId())
                        .setDate(data.getPriceDate())
                        .setPrice(data.getPrice())
                        .setProduct(product);
                productRepository.save(product);
                productPriceRepository.save(productPrice);
            }
            logger.log(Level.INFO,"Import done! Lines: " + csvProductDataList.size());
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error reading...");
            e.printStackTrace();
        }

    }
}
