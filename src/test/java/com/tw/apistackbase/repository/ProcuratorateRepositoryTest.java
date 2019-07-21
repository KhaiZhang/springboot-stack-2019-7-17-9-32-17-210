package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.model.CrimeInformation;
import com.tw.apistackbase.model.Procuratorate;
import com.tw.apistackbase.model.Prosecutor;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProcuratorateRepositoryTest {

    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Autowired
    private ProsecutorRepository prosecutorRepository;

    @Before
    public void setupData(){
        ArrayList<Prosecutor> prosecutors = new ArrayList<>();
        prosecutors.add(new Prosecutor("MR Wang"));
        prosecutors.add(new Prosecutor("MR Tang"));
        prosecutorRepository.saveAll(prosecutors);
        ArrayList<Procuratorate> procuratorates = new ArrayList<>();
        Procuratorate firstProcuratorate = new Procuratorate("郑州",prosecutors);
        Procuratorate secondProcuratorate = new Procuratorate("温州",prosecutors);
        procuratorates.add(firstProcuratorate);
        procuratorates.add(secondProcuratorate);
        procuratorateRepository.saveAll(procuratorates);
    }

    @Test
    public void should_reuturn_procuratorate_by_id() {
        long id = procuratorateRepository.findAll().get(0).getId();
        Procuratorate procuratorate= procuratorateRepository.findProcuratorateById(id);
        Assertions.assertEquals("郑州",procuratorate.getName());
    }

    @Test
    public void should_reuturn_prosecutor_included_by_procuratorate() {
        Procuratorate procuratorate = procuratorateRepository.findAll().stream().findAny().orElse(null);
        Assertions.assertNotNull(procuratorate.getProsecutor());
    }
}