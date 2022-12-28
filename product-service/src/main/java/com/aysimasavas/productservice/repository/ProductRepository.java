package com.aysimasavas.productservice.repository;

import com.aysimasavas.productservice.dto.ProductRequest;
import com.aysimasavas.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {
    List<Product> findByCategoryId(String categoryId);
}
