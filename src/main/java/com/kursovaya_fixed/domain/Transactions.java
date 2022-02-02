package com.kursovaya_fixed.domain;

import com.opencsv.bean.CsvBindByName;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @CsvBindByName(column = "customer_id")
    private Long customer_id;

    @CsvBindByName(column = "tr_datetime")
    private String  trDatetime;

    @CsvBindByName(column = "mcc_code")
    private Long mccCode;

    @CsvBindByName(column = "tr_type")
    private Long trType;

    @CsvBindByName(column = "amount")
    private Double amount;

    @CsvBindByName(column = "term_id")
    private String term_id;

    public Transactions() {}

    public Transactions(Long customer_id, String trDatetime, Long mccCode, Long trType, Double amount, String term_id) {
        this.customer_id = customer_id;
        this.trDatetime = trDatetime;
        this.mccCode = mccCode;
        this.trType = trType;
        this.amount = amount;
        this.term_id = term_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getTrDatetime() {
        return trDatetime;
    }

    public void setTrDatetime(String trDatetime) {
        this.trDatetime = trDatetime;
    }

    public Long getMccCode() {
        return mccCode;
    }

    public void setMccCode(Long mccCode) {
        this.mccCode = mccCode;
    }

    public Long getTrType() {
        return trType;
    }

    public void setTrType(Long trType) {
        this.trType = trType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTerm_id() {
        return term_id;
    }

    public void setTerm_id(String term_id) {
        this.term_id = term_id;
    }
}
