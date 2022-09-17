package com.bahar.review.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Description database table "store"
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store extends BaseEntity { //version 1

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "stock_store",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "stock_id"))
    private List<Stock> stockList = new ArrayList<>();
    @Column(length = 1000)
    private String details;
    private String address;
    private String phone;
    private String skype;
    private boolean discounts;
    private String mail;
    private String logo;
}
