package com.pieceauto.product;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

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
public class ProdcutCategory {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    @OneToMany(mappedBy = "prodcutCategory")
    private List<Product> produits;
}
