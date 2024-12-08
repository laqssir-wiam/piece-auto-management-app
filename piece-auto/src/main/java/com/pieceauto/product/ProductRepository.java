package com.pieceauto.product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author WIAM
 **/
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
