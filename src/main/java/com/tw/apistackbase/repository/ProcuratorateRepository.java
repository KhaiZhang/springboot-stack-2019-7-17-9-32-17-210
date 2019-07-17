package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Procuratorate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProcuratorateRepository extends JpaRepository<Procuratorate,Long> {
    Procuratorate findProcuratorateById(@PathVariable(value = "id") long id);
}
