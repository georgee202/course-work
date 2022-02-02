package com.kursovaya_fixed.parser;

import com.kursovaya_fixed.domain.GenderTrain;
import com.kursovaya_fixed.services.GenderTrainService;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class GenderTrainParse {
    private final static Logger logger = LoggerFactory.getLogger(GenderTrainService.class);
    public static List<GenderTrain> parse(MultipartFile file) {
        List<GenderTrain> genderTrainValues = null;
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            genderTrainValues = new CsvToBeanBuilder(reader)
                    .withType(GenderTrain.class)
                    .build()
                    .parse();
        } catch (RuntimeException | IOException e) {
            logger.error("Ошибка парсинга файла gender_train_cut");
        }
        return genderTrainValues;
    }
}