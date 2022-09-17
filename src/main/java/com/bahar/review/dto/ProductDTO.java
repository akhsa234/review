package com.bahar.review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotBlank(message = "name may not be empty.")
    @Column(unique = true)
    private String name;

    @NotBlank(message = "upc may not be empty.")
    @Column(unique = true)
    private String upc;

    @NotBlank(message = "description may not be empty.")
    @Size(max=250)
    private String description;
}
