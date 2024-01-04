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
public class InvoiceDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "invoice_discount_percent")
    private Integer percent;

    @Column(name = "invoice_discount_amount")
    private Long amount;

    @Column(name = "is_invoice_discount_used")
    private Boolean used;

    @Column(name = "invoice_discount_start_date")
    private LocalDateTime from;

    @Column(name = "invoice_discount_end_date")
    private LocalDateTime till;
}
