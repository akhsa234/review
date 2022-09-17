package com.bahar.review.convertor.supplier;


import com.bahar.review.dto.SupplierDTO;
import com.bahar.review.model.Supplier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DTOConvertToSupplier implements Converter<SupplierDTO, Supplier> {

    @Override
    public Supplier convert(SupplierDTO supplierDTO) {
        if (supplierDTO == null) {
            return null;
        }
        Supplier supplier = new Supplier();

        supplier.setName(supplierDTO.getName());
        supplier.setDescription(supplierDTO.getDescription());
        // image.setProduct()


        return supplier;
    }
}
