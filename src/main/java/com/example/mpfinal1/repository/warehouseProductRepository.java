package com.example.mpfinal1.repository;

import com.example.mpfinal1.model.warehouseProduct;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface warehouseProductRepository extends CrudRepository<warehouseProduct,Long> {
    public Integer countAllByAvailableFrom(LocalDate date);
}
