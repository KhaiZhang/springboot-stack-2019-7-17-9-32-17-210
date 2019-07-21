package com.tw.apistackbase.repository;

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

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProsecutorRepositoryTest {
    @Autowired
    private ProsecutorRepository prosecutorRepository;

    @Before
    public void setUpData(){
        ArrayList<Prosecutor> prosecutors = new ArrayList<>();
        prosecutors.add(new Prosecutor("MR Wang"));
        prosecutors.add(new Prosecutor("MR Tang"));
        prosecutorRepository.saveAll(prosecutors);
    }

    @Test
    public void should_reuturn_prosecutor_by_id() {
        Prosecutor prosecutor = prosecutorRepository.findAll().stream().findAny().orElse(null);
        long id = prosecutor.getId();
        Prosecutor actualProsecutor = prosecutorRepository.findById(id).orElse(null);
        Assertions.assertEquals(actualProsecutor,prosecutor);
    }


}