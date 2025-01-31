package com.pieceauto.category;

import com.pieceauto.common.PageResponse;
import com.pieceauto.product.Product;
import com.pieceauto.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WIAM
 **/
@Service
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }
    public ProductCategory addProductCat(String description){
        return ProductCategory.builder()
                .description(description)
                .build();
    }
    public PageResponse<ProductCategory> allProductCategory(int page, int size, Authentication connectedUser){
        User user = ((User) connectedUser.getPrincipal());
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<ProductCategory> productCats=productCategoryRepository.findAllProductCats(pageable,user.getId());
        List<ProductCategory> prodCatList = productCats.stream()
                .toList();
        return new PageResponse<>(
                prodCatList,
                productCats.getNumber(),
                productCats.getSize(),
                productCats.getTotalElements(),
                productCats.getTotalPages(),
                productCats.isFirst(),
                productCats.isLast()
        );
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
    public PageResponse<List<Product>> allProductOfCategory(Integer idCat,int page, int size, Authentication connectedUser){
        User user = ((User) connectedUser.getPrincipal());
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<List<Product>> products=productCategoryRepository.allProductOfACategory(pageable,user.getId(),idCat);
        List<List<Product>> prodList =products.stream()
                .toList();
        return new PageResponse<>(
                prodList,
                products.getNumber(),
                products.getSize(),
                products.getTotalElements(),
                products.getTotalPages(),
                products.isFirst(),
                products.isLast()
        );
    }
}
