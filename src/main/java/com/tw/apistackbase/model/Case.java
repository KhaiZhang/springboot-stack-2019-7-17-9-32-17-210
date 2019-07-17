package com.tw.apistackbase.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Case {
    @Id
    @GeneratedValue
    @Column(length = 255)
    private long id;
    @Column(nullable = false)
    private long time;
    @Column(nullable = false)
    private String name;

    public Case(){

    }
    public Case(long id, long time, String name) {
        this.id = id;
        this.time = time;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
