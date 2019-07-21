package com.tw.apistackbase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Prosecutor {
    @Id
    @GeneratedValue
    @Column(length = 255)
    private long id;

    @Column(nullable = false,length = 255)
    private String name;

    public Prosecutor() {
    }

    public Prosecutor(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
