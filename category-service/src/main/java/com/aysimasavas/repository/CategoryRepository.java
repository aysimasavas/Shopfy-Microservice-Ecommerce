package com.aysimasavas.repository;

import com.aysimasavas.dto.ProductResponse;
import com.aysimasavas.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category,String> {
}
