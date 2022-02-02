package com.kursovaya_fixed.parser;

import com.kursovaya_fixed.domain.Transactions;
import com.kursovaya_fixed.services.TransactionsService;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class TransactionsParse {
    private final static Logger logger = LoggerFactory.getLogger(TransactionsService.class);
    public static List<Transactions> parse(MultipartFile file) {
        List<Transactions> transactionsValues = null;
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            transactionsValues = new CsvToBeanBuilder(reader)
                    .withType(Transactions.class)
                    .build()
                    .parse();
        } catch (RuntimeException | IOException e) {
            logger.error("Ошибка парсинга файла transactions_cut");
        }
        return transactionsValues;
    }
}

