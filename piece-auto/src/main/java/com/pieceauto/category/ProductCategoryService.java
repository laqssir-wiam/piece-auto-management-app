package com.pieceauto.category;

import com.pieceauto.product.Product;
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
    public ProductCategory updateProductCategory(String description, Integer idCat){
        ProductCategory productCategory=productCategoryRepository.findById(idCat).get();
        productCategory.setDescription(description);
        return productCategoryRepository.save(productCategory);
    }
    public Integer deleteProductCategory(Integer idCat){
        productCategoryRepository.deleteById(idCat);
        return idCat;
    }
    public List<Product> allProductOfCategory(Integer idCat){
        return productCategoryRepository.findById(idCat).get().getProduits();
    }
}
