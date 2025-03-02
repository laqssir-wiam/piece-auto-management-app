package com.pieceauto.product;

/**
 * @author WIAM
 **/
public record ProductRequest(
         String reference,
         String label,
         String description,
         String quantity,
         Double price,
         Double margin_price,
         Integer category
) {
}
