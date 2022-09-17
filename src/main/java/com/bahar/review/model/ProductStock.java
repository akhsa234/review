package com.bahar.review.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductStock extends BaseEntity implements Serializable {//version1

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @OneToMany(mappedBy = "productStock", orphanRemoval = true)
    private Set<CartProductStock> cartProductStocks;

    private int productsCount;

    public ProductStock(final Product product, final Stock stock, final int productsCount) {
        this.product = product;
        this.stock = stock;
        this.productsCount = productsCount;
    }
}
