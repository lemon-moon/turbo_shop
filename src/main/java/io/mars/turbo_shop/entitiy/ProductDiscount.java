package io.mars.turbo_shop.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class ProductDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_discount_percent")
    private Integer percent;

    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "product_fk"))
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @Column(name = "product_discount_start_date")
    private LocalDateTime from;

    @Column(name = "product_discount_end_date")
    private LocalDateTime till;
}
