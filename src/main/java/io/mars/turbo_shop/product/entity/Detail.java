package io.mars.turbo_shop.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String detailKey;
    private String detailValue;

    public Detail(String key, String value) {
        this.detailKey = key;
        this.detailValue = value;
    }

    public static Detail of(String key, String value) {
        return new Detail(key, value);
    }

    public static List<Detail> of(String... keyValues) {
        List<Detail> details = new ArrayList<>();
        for (int index = 0; index < keyValues.length; index += 2) {
            String key = keyValues[index];
            String value = keyValues[index + 1];
            details.add(Detail.of(key, value));
        }
        return details;
    }
}

