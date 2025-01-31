package com.pieceauto.category;

import com.pieceauto.product.Product;
import com.pieceauto.user.User;
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
public class ProductCategory {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    @OneToMany(mappedBy = "prodcutCategory")
    private List<Product> produits;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;
}
