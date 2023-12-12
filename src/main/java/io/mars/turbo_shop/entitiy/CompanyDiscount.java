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
public class CompanyDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_discount_percent")
    private Integer percent;

    @JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "company_discount_fk"))
    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    @Column(name = "company_discount_start_date")
    private LocalDateTime from;

    @Column(name = "company_discount_end_date")
    private LocalDateTime till;
}
