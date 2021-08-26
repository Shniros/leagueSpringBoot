package ru.shniros.league.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shniros.league.LeagueApplication;
import ru.shniros.league.controller.dto.ProductCsvDTO;
import ru.shniros.league.repository.PriceRepository;
import ru.shniros.league.repository.ProductRepository;
import ru.shniros.league.repository.domain.Price;
import ru.shniros.league.repository.domain.Product;
import ru.shniros.league.utils.SmartCsvReader;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class LoadCsvFilesService {
    private static final Logger logger = Logger.getLogger(LoadCsvFilesService.class.getName());
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private ProductRepository productRepository;

    public void loadFiles(){
        //читаем csv- файл
        //<- path.properties кидаем туда путь к csv файлу

        SmartCsvReader reader = new SmartCsvReader();
        List<ProductCsvDTO> productCsvDTOList = null;
        try {
            productCsvDTOList = reader.readCsvFile();
            logger.log(Level.INFO,"Start import");
            for(ProductCsvDTO data: productCsvDTOList){
                Product product = new Product()
                        .setId(data.getProductId())
                        .setName(data.getProductName());
                Price price = new Price()
                        .setId(data.getPriceId())
                        .setDate(new SimpleDateFormat().parse(data.getPriceDate()))
                        .setPrice(data.getPrice())
                        .setProduct(product);
                productRepository.save(product);
                priceRepository.save(price);
            }
            logger.log(Level.INFO,"Import done! Lines: " + productCsvDTOList.size());
        } catch (IOException | ParseException e) {
            logger.log(Level.WARNING, "Error reading...",e);
        }
    }
}
