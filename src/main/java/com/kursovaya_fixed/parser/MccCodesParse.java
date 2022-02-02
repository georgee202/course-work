package com.kursovaya_fixed.parser;

import com.kursovaya_fixed.domain.MccCodes;
import com.kursovaya_fixed.services.MccCodesService;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class MccCodesParse {
    private final static Logger logger = LoggerFactory.getLogger(MccCodesService.class);
    public static List<MccCodes> parse(MultipartFile file) {
        List<MccCodes> mccCodesValues = null;
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            mccCodesValues = new CsvToBeanBuilder(reader)
                    .withType(MccCodes.class)
                    .withSeparator(';')
                    .build()
                    .parse();
        } catch (RuntimeException | IOException e) {
            logger.error("Ошибка парсинга файла tr_mcc_codes");
        }
        return mccCodesValues;
    }
}
