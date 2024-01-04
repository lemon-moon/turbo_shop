package io.mars.turbo_shop.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinTable(name = "product_primary_details",
            joinColumns = {@JoinColumn(
                    name = "product_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "product_primary_details_fk"))},
            inverseJoinColumns = {@JoinColumn(
                    name = "primary_detail_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "primary_detail_fk")
            )})
    private List<Detail> primaryDetails;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinTable(name = "secondary_product_details",
            joinColumns = {@JoinColumn(
                    name = "product_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "product_details_fk"))},
            inverseJoinColumns = {@JoinColumn(
                    name = "secondary_detail_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "secondary_detail_fk")
            )})
    private List<Detail> secondaryDetails;

    @ElementCollection
    @CollectionTable(
            name = "cost_snapshot",
            joinColumns = @JoinColumn(name = "product")
    )
    private List<Long> costs;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
}
