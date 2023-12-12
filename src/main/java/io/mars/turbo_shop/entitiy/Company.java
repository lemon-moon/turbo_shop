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
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "categories_for_company",
            joinColumns = {@JoinColumn(
                    name = "company_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "company_category_fk"))},
            inverseJoinColumns = {@JoinColumn(
                    name = "category_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "category_of_company_fk")
            )})
    private List<Category> categories;
}
