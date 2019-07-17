package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.model.CrimeInformation;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CirmeInformationRepositoryTest {

    @Autowired
    private CirmeInformationRepository cirmeInformationRepository;

    @Before
    public void setupData(){
        ArrayList<CrimeInformation> crimeInformations = new ArrayList<>();
        crimeInformations.add(new CrimeInformation("犯罪","犯罪2"));
        crimeInformations.add(new CrimeInformation("犯罪3","犯罪4"));
        crimeInformations.add(new CrimeInformation("犯罪5","犯罪6"));
        crimeInformations.add(new CrimeInformation("犯罪7","犯罪8"));
        cirmeInformationRepository.saveAll(crimeInformations);
    }

    @Test
    public void should_return_crime_information_by_id(){
        long id = cirmeInformationRepository.findAll().get(0).getId();
        CrimeInformation crimeInformation = cirmeInformationRepository.findById(id).get();
        Assertions.assertEquals("犯罪",crimeInformation.getObjectDesciption());
        Assertions.assertEquals("犯罪2",crimeInformation.getSuperisorDesciption());
    }
}