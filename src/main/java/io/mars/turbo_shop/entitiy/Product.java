package io.mars.turbo_shop.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    public Product(String name, Company company, List<Category> categories) {
        this.categories = categories;
        this.company = company;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String name;

    @JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "product_company_fk"))
    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    @OneToMany
    @JoinColumn(name = "product_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "product_detail_parent_fk"))
    private List<ProductDetail> productDetails;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "categories_for_product",
            joinColumns = {@JoinColumn(
                    name = "product_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "product_category_fk"))},
            inverseJoinColumns = {@JoinColumn(
                    name = "category_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "category_of_product_fk")
            )})
    private List<Category> categories;
}
