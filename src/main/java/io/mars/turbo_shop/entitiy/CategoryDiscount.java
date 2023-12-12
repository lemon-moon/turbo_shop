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
public class CategoryDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_discount_percent")
    private Integer percent;

    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "category_fk"))
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @Column(name = "category_discount_start_date")
    private LocalDateTime from;

    @Column(name = "category_discount_end_date")
    private LocalDateTime till;
}
