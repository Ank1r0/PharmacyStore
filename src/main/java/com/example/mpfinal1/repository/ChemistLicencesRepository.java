package com.example.mpfinal1.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.mpfinal1.model.ChemistLicences;

public interface ChemistLicencesRepository extends CrudRepository<ChemistLicences,Long> {
    ChemistLicences findFirstById(Long Id);
}
