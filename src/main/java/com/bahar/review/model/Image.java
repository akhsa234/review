package com.bahar.review.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Accessors(chain=true)
public class Image { //version2


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String name;
    private String description;
//    @Lob
//    byte[] content;
    private String path;
    private String url;



//    @ManyToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name = "images")
//    private Product product;
}
