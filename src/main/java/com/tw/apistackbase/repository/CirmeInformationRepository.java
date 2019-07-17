package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.model.CrimeInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface CirmeInformationRepository extends JpaRepository<CrimeInformation,Long> {
    CrimeInformation findCaseById(@PathVariable(value = "id") long id);
}
