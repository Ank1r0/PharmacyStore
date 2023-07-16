package com.example.mpfinal1.repository;

import com.example.mpfinal1.model.Licence;
import org.springframework.data.repository.CrudRepository;
import com.example.mpfinal1.model.ChemistLicences;

import java.util.List;

public interface LicenceRepository extends CrudRepository<Licence,Long> {
    List<Licence> findAllByStatusLike(String status);
  //  List<Licence> findAllByPack(Long id);

    List<Licence> findAllByPack(ChemistLicences chemistLicence);

    Licence findFirstById(Long id);

    void deleteLicencesById(Long id);

    //List<Licence> findAllByName(String name); ??
}
