package com.bahar.review.convertor.supplier;


import com.bahar.review.dto.SupplierDTO;
import com.bahar.review.model.Supplier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SupplierConvertToDTO implements Converter<Supplier, SupplierDTO> {


    @Override
    public SupplierDTO convert(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setName(supplier.getName());
        supplierDTO.setDescription(supplier.getDescription());


        return supplierDTO;
    }
}
