package io.mars.turbo_shop.entitiy;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Category {
    public Category(String name, Category parent) {
        this.parent = parent;
        this.title = name;
    }

    public Category(String name) {
        this.title = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "parent_fk"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Category parent;
}
