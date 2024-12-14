package com.pieceauto.category;

import org.springframework.stereotype.Service;

/**
 * @author WIAM
 **/
@Service
public class ProductCategoryService {
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }
    public ProductCategory addProductCat(String description){
        return ProductCategory.builder()
                .description(description)
                .build();
    }
}
