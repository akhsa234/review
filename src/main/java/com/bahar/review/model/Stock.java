package com.bahar.review.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Description database table "stock"
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {//extends BaseEntity { ////version 1


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @OneToMany(
            mappedBy = "stock",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},
            orphanRemoval = true)
    private Set<ProductStock> productStocks = new HashSet<>();

    @Column(unique = true, nullable = false)
    private String specialize;

    @ManyToOne
    @JoinColumn(name = "manager")
    private User manager;

    private String address;

    private String phone;

    private double square;

    private LocalTime openTime;

    private LocalTime closeTime;
}
