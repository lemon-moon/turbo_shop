package io.mars.turbo_shop.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "invoice_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "invoice_item_parent_fk"))
    private List<InvoiceItem> orderItems;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus invoiceStatus;

    @Column(name = "is_invoice_paid")
    private Boolean paid;

    @Column(name = "invoice_cost")
    private Double cost;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;
}
