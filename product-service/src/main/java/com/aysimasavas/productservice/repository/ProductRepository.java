package com.aysimasavas.productservice.repository;

import com.aysimasavas.productservice.dto.ProductRequest;
import com.aysimasavas.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
