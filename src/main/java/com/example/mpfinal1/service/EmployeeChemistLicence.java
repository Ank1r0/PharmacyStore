package com.example.mpfinal1.service;


import com.example.mpfinal1.model.Licence;
import com.example.mpfinal1.repository.ChemistLicencesRepository;
import com.example.mpfinal1.repository.EmployeeRepository;
import com.example.mpfinal1.repository.LicenceRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.mpfinal1.model.ChemistLicences;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeChemistLicence {

    private final EmployeeRepository employeeRepository;
    private final ChemistLicencesRepository chemistLicencesRepository;
    private final LicenceRepository licenceRepository;

      public List<Licence> getLicenceByChemistPack(Long id) {
       // Employee employee = employeeRepository.findFirstById(id);
        ChemistLicences chemistLicences = chemistLicencesRepository.findFirstById(id);
        List<Licence> licences = licenceRepository.findAllByPack(chemistLicences);

        return  licences;
    }


    public List<ChemistLicences> getAllChemistsPacks() {
        return (List<ChemistLicences>) chemistLicencesRepository.findAll();
    }

    public Licence fetchLicenceDetails(Long id) {
        return licenceRepository.findFirstById(id);
    }

    public Integer removeLicence(Long idLicence,Long idChemistPack){
        if(chemistLicencesRepository.findFirstById(idChemistPack).getLicence().size()==0){
            return -1;
        }
        licenceRepository.deleteLicencesById(idLicence);
        return 1;
    }


}
