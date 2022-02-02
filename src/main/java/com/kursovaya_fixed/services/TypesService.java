package com.kursovaya_fixed.services;

import com.kursovaya_fixed.domain.Types;
import com.kursovaya_fixed.repos.TypesRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypesService {
    private final TypesRepo repository;
    public TypesService(TypesRepo repository)
    {
        this.repository = repository;
    }
    @Transactional
    public void saveTypes(List<Types> typesValues)
    {
        repository.deleteAll();
        repository.saveAll(typesValues);
    }
}

