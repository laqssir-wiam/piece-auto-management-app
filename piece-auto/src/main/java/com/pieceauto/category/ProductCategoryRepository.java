package com.pieceauto.category;

import com.pieceauto.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author WIAM
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>, JpaSpecificationExecutor<ProductCategory> {
    @Query("""
                SELECT productCategory
                FROM ProductCategory productCategory
                WHERE productCategory.user_id = :userId
                """)
    Page<ProductCategory> findAllProductCats(Pageable pageable, Integer userId);

    @Query("""
                SELECT productCategory.produits
                FROM ProductCategory productCategory
                WHERE productCategory.user_id = :userId
                AND productCategory.id = :catId
                """)
    Page<List<Product>> allProductOfACategory(Pageable pageable, Integer userId, Integer catId);
}
