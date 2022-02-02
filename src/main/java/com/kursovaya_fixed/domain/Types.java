package com.kursovaya_fixed.domain;

import com.opencsv.bean.CsvBindByName;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class Types {
    @Id
    @CsvBindByName(column = "tr_type")
    private Long trType;

    @CsvBindByName(column = "tr_description")
    private String  trDescription;

    public Types() {}

    public Types(Long trType, String trDescription) {
        this.trType = trType;
        this.trDescription = trDescription;
    }

    public Long getTrType() {
        return trType;
    }

    public void setTrType(Long trType) {
        this.trType = trType;
    }

    public String getTrDescription() {
        return trDescription;
    }

    public void setTrDescription(String trDescription) {
        this.trDescription = trDescription;
    }
}
