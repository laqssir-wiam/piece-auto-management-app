package com.pieceauto.product;

import com.pieceauto.category.ProductCategoryRepository;
import org.springframework.stereotype.Service;

/**
 * @author WIAM
 **/
@Service
public class ProductMapper {
    private ProductCategoryRepository productCategoryRepository;
    public Product toProduct(ProductRequest productRequest) {
        return Product.builder()
                .label(productRequest.label())
                .quantity(productRequest.quantity())
                .reference(productRequest.reference())
                .description(productRequest.description())
                .price(productRequest.price())
                .margin_price(productRequest.margin_price())
                .prodcutCategory(productCategoryRepository.getReferenceById(productRequest.category()))
                .build();
    }
}
