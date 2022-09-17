package com.bahar.review.convertor.product;


import com.bahar.review.dto.ProductDTO;
import com.bahar.review.model.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DTOConvertToProduct implements Converter<ProductDTO, Product> {

    @Override
    public Product convert(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        // image.setProduct()


        return product;
    }
}
