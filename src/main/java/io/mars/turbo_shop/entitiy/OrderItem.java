package io.mars.turbo_shop.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Order order;

    @JoinColumn(name = "product_detail_id", foreignKey = @ForeignKey(name = "order_item_detail_fk"))
    @ManyToOne(fetch = FetchType.EAGER)
    private ProductDetail productDetail;

    @Column(name = "order_item_count")
    private Integer count;

    @Column(name = "order_item_cost")
    private Double cost;
}
