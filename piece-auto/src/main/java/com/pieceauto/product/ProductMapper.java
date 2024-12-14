package com.pieceauto.product;

import com.pieceauto.category.ProductCategoryRepository;

/**
 * @author WIAM
 **/
public class ProductMapper {
    private ProductCategoryRepository productCategoryRepository;
    public Product toProduct(ProductRequest productRequest) {
        return Product.builder()
                .label(productRequest.label())
                .quantity(productRequest.quantity())
                .reference(productRequest.reference())
                .description(productRequest.description())
                .price(productRequest.price())
                .prodcutCategory(productCategoryRepository.getReferenceById(productRequest.category()))
                .build();
    }
}
