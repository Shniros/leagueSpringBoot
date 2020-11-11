package ru.shniros.league.csv;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.shniros.league.LeagueApplication;
import ru.shniros.league.csv.csvreader.SmartCsvReader;
import ru.shniros.league.csv.dto.CsvProductData;
import ru.shniros.league.domain.Product;
import ru.shniros.league.domain.ProductPrice;
import ru.shniros.league.repository.ProductPriceRepository;
import ru.shniros.league.repository.ProductRepository;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Component
public class ImportCSV {
    private final ProductPriceRepository productPriceRepository;
    private final ProductRepository productRepository;
    private static final Logger logger = Logger.getLogger(LeagueApplication.class.getName());
    public void startImport(){
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
                        .setDate(sdfParser(data.getPriceDate()))
                        .setPrice(data.getPrice())
                        .setProduct(product);
                productRepository.save(product);
                productPriceRepository.save(productPrice);
            }
            logger.log(Level.INFO,"Import done! Lines: " + csvProductDataList.size());
        } catch (IOException e ) {
            logger.log(Level.SEVERE, "Error reading...",e);
        }
    }
    public static Date sdfParser(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            logger.log(Level.SEVERE, "Error parse...",e);
        }
        return null;
    }
}
