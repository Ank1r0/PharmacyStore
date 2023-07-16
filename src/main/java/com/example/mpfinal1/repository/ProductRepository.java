package com.example.mpfinal1.repository;

import com.example.mpfinal1.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long>  {

    public List<Product> findAllByName(String Name);
}
