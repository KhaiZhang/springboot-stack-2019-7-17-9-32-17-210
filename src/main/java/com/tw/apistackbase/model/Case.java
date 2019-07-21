package com.tw.apistackbase.model;



import org.hibernate.annotations.Cascade;

import javax.persistence.*;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crimeInformationId" , referencedColumnName = "id")
    private CrimeInformation crimeInformation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "procuratorateId" , referencedColumnName = "id",nullable = false)
    private Procuratorate procuratorate;

    public Case(){

    }
    public Case( long time, String name) {
        this.time = time;
        this.name = name;
    }
    public Case(long time, String name, CrimeInformation crimeInformation) {
        this.time = time;
        this.name = name;
        this.crimeInformation = crimeInformation;
    }

    public Case(long time, String name, CrimeInformation crimeInformation, Procuratorate procuratorate) {
        this.time = time;
        this.name = name;
        this.crimeInformation = crimeInformation;
        this.procuratorate = procuratorate;
    }

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }

    public CrimeInformation getCrimeInformation() {
        return crimeInformation;
    }

    public void setCrimeInformation(CrimeInformation crimeInformation) {
        this.crimeInformation = crimeInformation;
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
