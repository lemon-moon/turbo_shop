package io.mars.turbo_shop.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @JoinColumn(name = "price_id", foreignKey = @ForeignKey(name = "price_detail_fk"))
    @ManyToOne(fetch = FetchType.EAGER)
    private Detail detail;

    private Double cost;
}
