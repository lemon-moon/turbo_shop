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
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "cart_item_parent_fk"))
    private List<CartItem> cartItems;

    @Column(name = "cart_cost")
    private Double cost;

    @Column(name = "create_date")
    private LocalDateTime createDate;
}
