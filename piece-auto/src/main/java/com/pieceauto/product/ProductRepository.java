package com.pieceauto.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author WIAM
 **/
public interface ProductRepository extends JpaRepository<Product,Integer> , JpaSpecificationExecutor<Product> {
    @Query("""
            SELECT book
            FROM Product product
            WHERE product.reference = :ref
            """)
    Product findByRef(String ref);
}
