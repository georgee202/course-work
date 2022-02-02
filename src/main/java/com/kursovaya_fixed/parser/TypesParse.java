package com.kursovaya_fixed.parser;

import com.kursovaya_fixed.domain.Types;
import com.kursovaya_fixed.services.TypesService;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class TypesParse {
    private final static Logger logger = LoggerFactory.getLogger(TypesService.class);
    public static List<Types> parse(MultipartFile file) {
        List<Types> typesValues = null;
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            typesValues = new CsvToBeanBuilder(reader)
                    .withType(Types.class)
                    .withSeparator(';')
                    .build()
                    .parse();
        } catch (RuntimeException | IOException e) {
            logger.error("Ошибка парсинга файла tr_types");
        }
        return typesValues;
    }
}
