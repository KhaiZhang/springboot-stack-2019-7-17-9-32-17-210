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
        cases.add(new Case(131324512,"olderCase"));
        caseRepository.saveAll(cases);
    }

    @Test
    public void should_return_correct_case_when_find_case_by_id() {
        long id = caseRepository.findAll().get(0).getId();
        Case casee= caseRepository.findCaseById(id);
        Assertions.assertEquals(casee.getName(),"childCase");
        Assertions.assertEquals(casee.getTime(),123456789);
    }

    @Test
    public void should_return_all_case_order_by_time() {
        List<Case> cases = caseRepository.findAllByOrderByTimeDesc();
        Assertions.assertEquals(cases.size(),4);
        Assertions.assertEquals(cases.get(0).getTime(),234166782);
    }

    @Test
    public void should_return_all_case_by_name() {
        List<Case> cases = caseRepository.findAllByName("olderCase");
        Assertions.assertEquals(cases.size(),2);
        Assertions.assertEquals(cases.get(0).getName(),"olderCase");
    }

    @Test
    public void should_delete_case_by_id() {
        Case aCase = caseRepository.findAll().get(1);
        System.out.println(aCase.getId());
        caseRepository.deleteById(aCase.getId());
        Assertions.assertEquals(caseRepository.findAll().size(),3);
    }
}