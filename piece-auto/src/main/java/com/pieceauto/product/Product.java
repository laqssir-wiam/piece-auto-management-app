package com.pieceauto.product;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author WIAM
 **/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id
    private Integer id;
    private String reference;
    private String label;
    private String description;
    private String quantity;
    private Double price;
    private ProdcutCategory category;
}
