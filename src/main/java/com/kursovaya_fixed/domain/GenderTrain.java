package com.kursovaya_fixed.domain;

import com.opencsv.bean.CsvBindByName;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gender_train")
public class GenderTrain {
    @Id
    @CsvBindByName(column = "customer_id")
    private Long customer_id;

    @CsvBindByName(column = "gender")
    private Integer gender;

    public GenderTrain() {}

    public GenderTrain(Long customer_id, Integer gender) {
        this.customer_id = customer_id;
        this.gender = gender;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
