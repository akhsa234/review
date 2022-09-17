package com.bahar.review.dto.version1;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
public class ProductDto {
    private String id;

    @NotNull
    private String name;

    @NotNull
    private double cost;

    @NotNull
    private String type;

    @Size(max = 500)
    private String details;
    private String image;
    private double width;
    private double height;
    private double weight;
    private LocalDateTime manufactureDate;
}
