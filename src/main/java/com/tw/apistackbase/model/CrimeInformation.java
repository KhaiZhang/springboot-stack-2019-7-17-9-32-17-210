package com.tw.apistackbase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CrimeInformation {

    @Id
    @GeneratedValue
    @Column(length = 255)
    private long id;
    @Column(nullable = false,length = 255)
    private String objectDesciption;
    @Column(nullable = false,length = 255)
    private String superisorDesciption;



    public CrimeInformation() {
    }

    public CrimeInformation(String objectDesciption, String superisorDesciption) {
        this.objectDesciption = objectDesciption;
        this.superisorDesciption = superisorDesciption;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObjectDesciption() {
        return objectDesciption;
    }

    public void setObjectDesciption(String objectDesciption) {
        this.objectDesciption = objectDesciption;
    }

    public String getSuperisorDesciption() {
        return superisorDesciption;
    }

    public void setSuperisorDesciption(String superisorDesciption) {
        this.superisorDesciption = superisorDesciption;
    }
}
