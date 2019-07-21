package com.tw.apistackbase.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Procuratorate {
    @Id
    @GeneratedValue
    @Column(length = 255)
    private long id;

    @Column(nullable = false,unique = true,length = 50)
    private String name;

    @OneToMany
    @JoinColumn(name = "prosecutorId" , referencedColumnName = "id")
    private List<Prosecutor> prosecutor;

    public Procuratorate() {
    }

    public Procuratorate(String name) {
        this.name = name;
    }

    public Procuratorate(String name, List<Prosecutor> prosecutor) {
        this.name = name;
        this.prosecutor = prosecutor;
    }

    public List<Prosecutor> getProsecutor() {
        return prosecutor;
    }

    public void setProsecutor(List<Prosecutor> prosecutor) {
        this.prosecutor = prosecutor;
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
