package com.kursovaya_fixed.repos;

import com.kursovaya_fixed.domain.Transactions;
import com.kursovaya_fixed.view.TransactionsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionsRepo extends JpaRepository<Transactions, Long> {

    @Query (value = "SELECT tr.customer_id AS CustomerID, tr.tr_datetime AS DateTime, ty.tr_description AS Description," +
            "tr.mcc_code AS MccCode, tr.amount, tr.term_id AS Terminal FROM types AS ty \n" +
            "JOIN transactions AS tr ON ty.tr_type = tr.tr_type \n" +
            "WHERE UPPER(ty.tr_description) LIKE UPPER(CONCAT('%', :str, '%'))", nativeQuery = true)
    List<TransactionsView> findByRequest(@Param("str") String str);
}