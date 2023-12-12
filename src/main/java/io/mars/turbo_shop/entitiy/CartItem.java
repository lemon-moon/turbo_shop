package io.mars.turbo_shop.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cart cart;

    @JoinColumn(name = "product_detail_id", foreignKey = @ForeignKey(name = "cart_item_product_detail_fk"))
    @ManyToOne(fetch = FetchType.EAGER)
    private ProductDetail productDetail;

    @Column(name = "product_count")
    private Integer count;

    @Column(name = "product_cost")
    private Double cost;
}
