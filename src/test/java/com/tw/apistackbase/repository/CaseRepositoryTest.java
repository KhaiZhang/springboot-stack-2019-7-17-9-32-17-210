package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.model.CrimeInformation;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class CaseRepositoryTest {

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private CirmeInformationRepository cirmeInformationRepository;

    @Before
    public void setupData(){
        ArrayList<CrimeInformation> crimeInformations = new ArrayList<>();
        CrimeInformation firstCrimeInformation = new CrimeInformation("犯罪", "犯罪2");
        CrimeInformation secondCrimeInformation = new CrimeInformation("犯罪3", "犯罪4");
        CrimeInformation thirdCrimeInformation = new CrimeInformation("犯罪5", "犯罪6");
        CrimeInformation forthCrimeInformation = new CrimeInformation("犯罪7", "犯罪8");
        crimeInformations.add(firstCrimeInformation);
        crimeInformations.add(secondCrimeInformation);
        crimeInformations.add(thirdCrimeInformation);
        crimeInformations.add(forthCrimeInformation);
        cirmeInformationRepository.saveAll(crimeInformations);
        List<Case> cases = new ArrayList<>();
        cases.add(new Case(123456789,"childCase",firstCrimeInformation));
        cases.add(new Case(234166782,"adultCase",secondCrimeInformation));
        cases.add(new Case(231324512,"olderCase",thirdCrimeInformation));
        cases.add(new Case(131324512,"olderCase",forthCrimeInformation));
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

//    @Test
//    public void should_update_crime_information_by_case_id(){
//        long id = caseRepository.findAll().get(0).getId();
//        CrimeInformation crimeInformation = new CrimeInformation("犯罪9", "犯罪10");
//        cirmeInformationRepository.save(crimeInformation);
//        caseRepository.updateCaseCrimeInformation(id,crimeInformation);
//        Case aCase = caseRepository.findById(id).get();
//        Assertions.assertEquals("犯罪9",aCase.getCrimeInformation().getObjectDesciption());
//        Assertions.assertEquals("犯罪10",aCase.getCrimeInformation().getSuperisorDesciption());
//    }
}