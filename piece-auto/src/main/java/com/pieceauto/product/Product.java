package com.pieceauto.product;

import com.pieceauto.category.ProdcutCategory;
import jakarta.persistence.*;
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
    @GeneratedValue
    private Integer id;
    private String reference;
    private String label;
    private String description;
    private String quantity;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category")
    private ProdcutCategory prodcutCategory;
}
