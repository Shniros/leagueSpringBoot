package ru.shniros.league.csvreader;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import ru.shniros.league.LeagueApplication;
import ru.shniros.league.csvreader.dto.CsvProductData;
import ru.shniros.league.domain.Product;

import java.io.*;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SmartCsvReader {
    private static final Logger logger = Logger.getLogger(SmartCsvReader.class.getName());


    public List<CsvProductData> readCsvFile() throws IOException {
        Properties pathFile = new Properties();
        FileReader readerPath = new FileReader("src/main/resources/path.properties");;
        pathFile.load(readerPath);
        readerPath.close();
        logger.log(Level.INFO,"Start reading: " + pathFile.get("path").toString());
        FileReader reader = new FileReader(pathFile.get("path").toString());
        CsvToBean<CsvProductData>   csvtobean = new CsvToBeanBuilder<CsvProductData>(reader)
                                                    .withType(CsvProductData.class)
                                                    .withSeparator(';')
                                                    .build();

        //reader.close();
        return csvtobean.parse();
    }

}
