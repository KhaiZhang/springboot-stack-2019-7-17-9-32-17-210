package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.model.CrimeInformation;
import com.tw.apistackbase.model.Procuratorate;
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

    @Before
    public void setupData(){
        ArrayList<Procuratorate> procuratorates = new ArrayList<>();
        Procuratorate procuratorate1 = new Procuratorate("郑州");
        Procuratorate procuratorate2 = new Procuratorate("温州");
        procuratorates.add(procuratorate1);
        procuratorates.add(procuratorate2);
        procuratorateRepository.saveAll(procuratorates);
    }

    @Test
    public void should_reuturn_procuratorate_by_id() {
        long id = procuratorateRepository.findAll().get(0).getId();
        Procuratorate procuratorate= procuratorateRepository.findProcuratorateById(id);
        Assertions.assertEquals("郑州",procuratorate.getName());
    }
}