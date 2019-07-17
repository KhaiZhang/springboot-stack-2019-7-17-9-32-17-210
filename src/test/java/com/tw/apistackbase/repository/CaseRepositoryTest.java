package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class CaseRepositoryTest {

    @Autowired
    private CaseRepository caseRepository;

    @Before
    public void setupData(){
        List<Case> cases = new ArrayList<>();
        cases.add(new Case(123456789,"childCase"));
        cases.add(new Case(234166782,"adultCase"));
        cases.add(new Case(231324512,"olderCase"));
        caseRepository.saveAll(cases);
    }

    @Test
    public void findCaseById() {
        Case casee= caseRepository.findCaseById(1);
        Assertions.assertEquals(casee.getName(),"childCase");
        Assertions.assertEquals(casee.getTime(),123456789);

    }
}