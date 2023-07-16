package com.example.mpfinal1.repository;

import com.example.mpfinal1.model.Store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends CrudRepository<Store,Long> {
    public List<Store> findByName(Store name);
    public List<Store> findByNameAndAddress(Store name, String address);

    @Query("from Store as s left join fetch s.employees where s.id = :id")
    public Optional<Store> findById(@Param("id") Long id);
}
