package com.kursovaya_fixed.services;

import com.kursovaya_fixed.domain.Transactions;
import com.kursovaya_fixed.repos.TransactionsRepo;
import com.kursovaya_fixed.view.TransactionsView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionsService {
    private final TransactionsRepo repository;

    public TransactionsService(TransactionsRepo repository) {
        this.repository = repository;
    }

    @Transactional
    public void saveTransactions(List<Transactions> transactionsValues)
    {
        repository.deleteAll();
        repository.saveAll(transactionsValues);
    }

    public List<TransactionsView> findByRequest(String str){
        return repository.findByRequest(str);
    }

}
