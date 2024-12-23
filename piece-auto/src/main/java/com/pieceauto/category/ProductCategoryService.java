package com.pieceauto.category;

import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<ProductCategory> allProductCategory(){
        return productCategoryRepository.findAll();
    }
    public ProductCategory findProductCategoryById(Integer id){
        return productCategoryRepository.findById(id).get();
    }
}
