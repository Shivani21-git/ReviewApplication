package com.example.myprojects.review_application.repository;

import com.example.myprojects.review_application.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product,Integer> {
    Product findByProductName(String productName);
}
