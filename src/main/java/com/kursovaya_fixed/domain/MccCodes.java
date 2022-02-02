package com.kursovaya_fixed.domain;

import com.opencsv.bean.CsvBindByName;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mcc_codes")
public class MccCodes {
    @Id
    @CsvBindByName(column = "mcc_code")
    private Integer mccCode;

    @CsvBindByName(column = "mcc_description")
    private String mccDescription;

    public MccCodes() {}

    public MccCodes(Integer mccCode, String mccDescription) {
        this.mccCode = mccCode;
        this.mccDescription = mccDescription;
    }

    public Integer getMccCode() {
        return mccCode;
    }

    public String getMccDescription() {
        return mccDescription;
    }

    public void setMccCode(Integer mccCode) {
        this.mccCode = mccCode;
    }

    public void setMccDescription(String mccDescription) {
        this.mccDescription = mccDescription;
    }
}

