package com.aysimasavas.controller;

import com.aysimasavas.dto.CategoryRequest;
import com.aysimasavas.dto.CategoryResponse;
import com.aysimasavas.dto.ProductResponse;
import com.aysimasavas.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@RequestBody CategoryRequest categoryRequest){
        categoryService.createCategory(categoryRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProductsByCategoryId(@PathVariable("id") String id){
        return categoryService.getAllProductsByCategoryId(id);
    }
}
