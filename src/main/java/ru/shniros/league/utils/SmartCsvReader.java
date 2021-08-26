package ru.shniros.league.utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import ru.shniros.league.controller.dto.ProductCsvDTO;

import java.io.*;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SmartCsvReader {
    private static final Logger logger = Logger.getLogger(SmartCsvReader.class.getName());


    public List<ProductCsvDTO> readCsvFile() throws IOException {
        Properties pathFile = new Properties();
        FileReader readerPath = new FileReader("src/main/resources/path.properties");;
        pathFile.load(readerPath);
        readerPath.close();
        logger.log(Level.INFO,"Start reading: " + pathFile.get("path").toString());
        FileReader reader = new FileReader(pathFile.get("path").toString());
        CsvToBean<ProductCsvDTO>   csvtobean = new CsvToBeanBuilder<ProductCsvDTO>(reader)
                                                    .withType(ProductCsvDTO.class)
                                                    .withSeparator(';')
                                                    .build();

        //reader.close();
        return csvtobean.parse();
    }

}
