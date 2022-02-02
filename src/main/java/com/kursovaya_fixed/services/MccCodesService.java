package com.kursovaya_fixed.services;

import com.kursovaya_fixed.domain.MccCodes;
import com.kursovaya_fixed.repos.MccCodesRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MccCodesService {
    private final MccCodesRepo repository;
    public MccCodesService(MccCodesRepo repository)
    {
        this.repository = repository;
    }
    @Transactional
    public void saveMccCodes(List<MccCodes> mccCodesValues)
    {
        repository.deleteAll();
        repository.saveAll(mccCodesValues);
    }
}