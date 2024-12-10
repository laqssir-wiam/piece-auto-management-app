package com.pieceauto.product;

import com.pieceauto.category.ProdcutCategory;

/**
 * @author WIAM
 **/
public record ProductRequest(
         String reference,
         String label,
         String description,
         String quantity,
         Double price,
         Integer category
) {
}
