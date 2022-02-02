package com.kursovaya_fixed.controller;

import com.kursovaya_fixed.parser.GenderTrainParse;
import com.kursovaya_fixed.parser.MccCodesParse;
import com.kursovaya_fixed.parser.TransactionsParse;
import com.kursovaya_fixed.parser.TypesParse;
import com.kursovaya_fixed.services.GenderTrainService;
import com.kursovaya_fixed.services.MccCodesService;
import com.kursovaya_fixed.services.TransactionsService;
import com.kursovaya_fixed.services.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class MainController {

    private final GenderTrainService genderTrainService;
    private final MccCodesService mccCodesService;
    private final TransactionsService transactionsService;
    private final TypesService typesService;

    @Autowired
    public MainController(GenderTrainService genderTrainService, MccCodesService mccCodesService, TransactionsService transactionsService, TypesService typesService) {
        this.genderTrainService = genderTrainService;
        this.mccCodesService = mccCodesService;
        this.transactionsService = transactionsService;
        this.typesService = typesService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @PostMapping("/")
    public String uploadCSVFiles(Model model, @RequestParam("file") MultipartFile file)
    {
        if (Objects.equals(file.getOriginalFilename(), "gender_train_cut.csv"))
        {
            genderTrainService.saveGenderTrain(GenderTrainParse.parse(file));
            model.addAttribute("uploadGender", "Файл gender_train_cut успешно загружен");
        }
        else if (Objects.equals(file.getOriginalFilename(), "tr_mcc_codes.csv"))
        {
            mccCodesService.saveMccCodes(MccCodesParse.parse(file));
            model.addAttribute("uploadMCC", "Файл tr_mcc_codes успешно загружен");
        }
        else if (Objects.equals(file.getOriginalFilename(), "transactions_cut.csv"))
        {
            transactionsService.saveTransactions(TransactionsParse.parse(file));
            model.addAttribute("uploadTransactions", "Файл transactions_cut успешно загружен");
        }
        else if (Objects.equals(file.getOriginalFilename(), "tr_types.csv"))
        {
            typesService.saveTypes(TypesParse.parse(file));
            model.addAttribute("uploadTypes", "Файл tr_types успешно загружен");
        }
        else
        {
            model.addAttribute("message", "Ошибка названия файла");
        }
        return "index";
    }

    @GetMapping("/results")
    public String results(){
        return "finish";
    }

    @PostMapping("/results")
    public String resultsPrint(@RequestParam("str") String str, Model model){
        var results = transactionsService.findByRequest(str);
        List<List<String>> resultsValues = new ArrayList<>();

        for (var result : results){
            List<String> tmp = new ArrayList<>();
            tmp.add(result.getCustomerID().toString());
            tmp.add(result.getDateTime());
            tmp.add(result.getDescription());
            tmp.add(result.getMccCode().toString());
            tmp.add(result.getAmount().toString());
            tmp.add(result.getTerminal());
            resultsValues.add(tmp);
        }
        model.addAttribute("results", resultsValues);
        return "finish";
    }

}
