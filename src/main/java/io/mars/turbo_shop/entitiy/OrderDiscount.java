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
public class OrderDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_discount_percent")
    private Integer percent;

    @Column(name = "order_discount_amount")
    private Long amount;

    @Column(name = "is_order_discount_used")
    private Boolean used;

    @Column(name = "order_discount_start_date")
    private LocalDateTime from;

    @Column(name = "order_discount_end_date")
    private LocalDateTime till;
}
