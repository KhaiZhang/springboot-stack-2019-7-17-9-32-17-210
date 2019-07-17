package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface CaseRepository extends JpaRepository<Case,Long>{
        Case findCaseById(@PathVariable(value = "id") long id);
}
