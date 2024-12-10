package com.pieceauto.product;

import org.springframework.stereotype.Service;

/**
 * @author WIAM
 **/
@Service
public class ProductService {
    private ProductRepository productRepository;
    private ProductMapper productMapper;
    public Product saveProduct(ProductRequest productRequest){
        return  productRepository.save(productMapper.toProduct(productRequest));
    }
}
