package com.bahar.review.model;



import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Description database table "cart"
 */
@Entity
@Data
@AllArgsConstructor
public class Cart extends BaseEntity {

    public Cart() {
        this.createDate = LocalDateTime.now();
    }

    public Cart(final User user) {
        this.createDate = LocalDateTime.now();
        this.user = user;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User user;
    private LocalDateTime createDate;
    private double totalCost;

    @OneToMany(
            mappedBy = "cart",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},
            orphanRemoval = true)
    private Set<CartProductStock> cartProductStocks = new HashSet<>();


}
