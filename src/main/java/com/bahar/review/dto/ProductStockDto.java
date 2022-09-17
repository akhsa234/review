package com.bahar.review.dto;

import com.bahar.review.dto.version1.ProductDto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductStockDto {

    private ProductDto product;
    private int productsCount;

}
