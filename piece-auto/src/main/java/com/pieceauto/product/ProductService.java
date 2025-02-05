package com.pieceauto.product;

import com.pieceauto.category.ProductCategory;
import com.pieceauto.category.ProductCategoryRepository;
import com.pieceauto.common.PageResponse;
import com.pieceauto.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author WIAM
 **/
@Service
public class ProductService {
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductCategoryRepository productCategoryRepository, ProductRepository productRepository, ProductMapper productMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product saveProduct(ProductRequest productRequest){
        return  productRepository.save(productMapper.toProduct(productRequest));
    }
    public Product findById(Integer id){
        return productRepository.findById(id).get();
    }

    public PageResponse<Product> findAll(int page, int size, Authentication connectedUser){
        User user = ((User) connectedUser.getPrincipal());
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<Product> products=productRepository.findAllProducts(pageable,user.getId());
        List<Product> prodList = products.stream()
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
    public Product updateProduct(ProductRequest productRequest, Integer idProd){
        Product product = findById(idProd);
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
    public ProductCategory getCatOfProduct(Integer idProd){
        return productRepository.findById(idProd).get().getProdcutCategory();
    }


    public Product getByRef(String ref){
        return productRepository.findByRef(ref);
    }
}
