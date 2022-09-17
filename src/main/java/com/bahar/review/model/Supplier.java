package com.bahar.review.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 *
 */
@Data
@Entity
@Accessors(chain=true)
public class Supplier {//version2

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // @NotNull
    private String name;
    private String description;

//   @OneToMany(mappedBy = "supplier")
//   private List<Product> supplierProductList;

}
