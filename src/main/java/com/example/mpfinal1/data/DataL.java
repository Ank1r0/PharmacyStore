package com.example.mpfinal1.data;

import com.example.mpfinal1.model.*;
import com.example.mpfinal1.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.mpfinal1.repository.ChemistLicencesRepository;
import com.example.mpfinal1.repository.LicenceRepository;

import java.time.LocalDate;


@Component
@AllArgsConstructor
public class DataL implements ApplicationRunner {

    private final ChemistLicencesRepository chemistLicencesRepository;
    private final LicenceRepository licenceRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        ChemistLicences chemistLicences = ChemistLicences.builder()
                .desc("Pack of licences of Employee N").build();



        if(licenceRepository.count() == 0)
        {
            if(chemistLicencesRepository.count() > 2) chemistLicencesRepository.deleteAll();
            chemistLicencesRepository.save(chemistLicences);

            Licence licence = Licence.builder()
                    .Name("Licence1").pack(chemistLicences).Name("Licence ABC").expirationDate(LocalDate.now()).status(LicenceStatus.Valid).build();
            Licence licence1 = Licence.builder()
                                .Name("Licence1").pack(chemistLicences).Name("Licence BCA").expirationDate(LocalDate.now()).status(LicenceStatus.Valid).build();
            Licence licence2 = Licence.builder()
                                .Name("Licence1").pack(chemistLicences).Name("CBA").expirationDate(LocalDate.now()).status(LicenceStatus.Valid).build();



            licenceRepository.save(licence);
            licenceRepository.save(licence1);
            licenceRepository.save(licence2);
        }


    }
}
