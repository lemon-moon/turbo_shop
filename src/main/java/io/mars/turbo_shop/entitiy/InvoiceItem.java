package io.mars.turbo_shop.entitiy;

import io.mars.turbo_shop.product.entity.ProductDetail;
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
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Invoice invoice;

    @JoinColumn(name = "product_detail_id", foreignKey = @ForeignKey(name = "invoice_item_detail_fk"))
    @ManyToOne(fetch = FetchType.EAGER)
    private ProductDetail productDetail;

    @Column(name = "invoice_item_count")
    private Integer count;

    @Column(name = "invoice_item_cost")
    private Double cost;
}
