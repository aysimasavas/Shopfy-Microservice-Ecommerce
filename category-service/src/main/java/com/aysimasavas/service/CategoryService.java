package com.aysimasavas.service;

import com.aysimasavas.dto.CategoryRequest;
import com.aysimasavas.dto.CategoryResponse;
import com.aysimasavas.dto.ProductResponse;
import com.aysimasavas.model.Category;
import com.aysimasavas.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final WebClient.Builder webClientBuilder;
    public void createCategory(CategoryRequest categoryRequest){
        Category category= Category.builder()
            .categoryId(categoryRequest.getCategoryId())
            .categoryName(categoryRequest.getCategoryName())
            .description(categoryRequest.getDescription())
            .build();

        categoryRepository.save(category);
        log.info("category {} is saved",category.getId());
    }

    public List<CategoryResponse> getAllCategories(){
        List<Category> categories=categoryRepository.findAll();
        return categories.stream().map(this::mapToCategories).toList();
    }

    private CategoryResponse mapToCategories(Category category) {
        CategoryResponse categoryResponse= CategoryResponse.builder()
            .id(category.getId())
            .categoryId(category.getCategoryId())
            .categoryName(category.getCategoryName())
            .description(category.getDescription())
            .build();
        return categoryResponse;
    }

    public List<ProductResponse> getAllProductsByCategoryId(String id){
        ProductResponse[] productResponses=webClientBuilder.build().get()
            .uri("http://product-service/api/product/products/"+id,uriBuilder -> uriBuilder
                .queryParam("categoryId",id).build())
            .retrieve()
            .bodyToMono(ProductResponse[].class)
            .block();

        return Arrays.stream(productResponses).toList();
    }
}
