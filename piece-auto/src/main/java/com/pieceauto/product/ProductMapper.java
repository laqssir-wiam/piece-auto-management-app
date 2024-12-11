package com.pieceauto.product;

import com.pieceauto.category.ProdcutCategory;
import com.pieceauto.category.ProdcutCategoryRepository;

/**
 * @author WIAM
 **/
public class ProductMapper {
    private ProdcutCategoryRepository prodcutCategoryRepository;
    public Product toProduct(ProductRequest productRequest) {
        return Product.builder()
                .label(productRequest.label())
                .quantity(productRequest.quantity())
                .reference(productRequest.reference())
                .description(productRequest.description())
                .price(productRequest.price())
                .prodcutCategory(prodcutCategoryRepository.getReferenceById(productRequest.category()))
                .build();
    }
}
