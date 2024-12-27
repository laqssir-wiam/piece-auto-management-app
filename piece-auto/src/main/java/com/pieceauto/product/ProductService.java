package com.pieceauto.product;

import com.pieceauto.category.ProductCategory;
import com.pieceauto.category.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author WIAM
 **/
@Service
public class ProductService {
    private ProductCategoryRepository productCategoryRepository;
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductService(ProductCategoryRepository productCategoryRepository, ProductRepository productRepository, ProductMapper productMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

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
        product.setMargin_price(productRequest.margin_price());
        product.setLabel(productRequest.label());
        product.setDescription(productRequest.description());
        product.setQuantity(productRequest.quantity());
        product.setReference(productRequest.reference());
        product.setProdcutCategory(productCategoryRepository.findById(productRequest.category()).get());
        return productRepository.save(product);
    }
    public void deleteProduct(Product prod){
         productRepository.delete(prod);
    }
    public ProductCategory productCat(Integer idProd){
        return productRepository.findById(idProd).get().getProdcutCategory();
    }
    public
}
