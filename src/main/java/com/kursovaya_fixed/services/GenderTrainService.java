package com.kursovaya_fixed.services;

import com.kursovaya_fixed.domain.GenderTrain;
import com.kursovaya_fixed.repos.GenderTrainRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GenderTrainService {
    private final GenderTrainRepo repository;
    public GenderTrainService(GenderTrainRepo repository)
    {
        this.repository = repository;
    }
    @Transactional
    public void saveGenderTrain(List<GenderTrain> genderTrainValues)
    {
        repository.deleteAll();
        repository.saveAll(genderTrainValues);
    }
}
