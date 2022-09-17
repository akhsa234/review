package com.bahar.review.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Accessors(chain=true)
public class Product { //version2

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String name;
    private String upc;
    private String description;

//   @OneToMany(cascade = CascadeType.ALL)
//   private Set<Image> photos;
//
//   @ManyToOne(cascade = CascadeType.ALL)
//   @JoinColumn(name = "SuppliersProduct")
//   private Supplier supplier;
//
//   @ManyToOne(cascade = CascadeType.ALL)
//   @JoinColumn(name="CategoryOfProduct")
//   private Category category;
}
