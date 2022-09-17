package com.bahar.review.convertor.product;


import com.bahar.review.dto.ProductDTO;
import com.bahar.review.model.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductConvertToDTO implements Converter<Product, ProductDTO> {


    @Override
    public ProductDTO convert(Product product) {
        if (product == null) {
            return null;
        }
        ProductDTO productDTO= new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setUpc(product.getUpc());
        productDTO.setDescription(product.getDescription());



        return productDTO;
    }
}
