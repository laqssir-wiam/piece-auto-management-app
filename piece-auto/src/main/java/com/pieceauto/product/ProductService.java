package com.pieceauto.product;

import com.pieceauto.category.ProdcutCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author WIAM
 **/
@Service
public class ProductService {
    private ProdcutCategoryRepository prodcutCategoryRepository;
    private ProductRepository productRepository;
    private ProductMapper productMapper;
    public Product saveProduct(ProductRequest productRequest){
        return  productRepository.save(productMapper.toProduct(productRequest));
    }
    public Optional<Product> findById(Integer id){
        return productRepository.findById(id);
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product updateProduct(ProductRequest productRequest, Integer idProd){
        Product product = findById(idProd).get();
        product.setPrice(productRequest.price());
        product.setLabel(productRequest.label());
        product.setDescription(productRequest.description());
        product.setQuantity(productRequest.quantity());
        product.setReference(productRequest.reference());
        product.setProdcutCategory(prodcutCategoryRepository.findById(productRequest.category()).get());
        return productRepository.save(product);
    }
}
