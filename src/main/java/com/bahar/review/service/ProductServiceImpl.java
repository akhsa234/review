package com.bahar.review.service;


import com.bahar.review.convertor.product.DTOConvertToProduct;
import com.bahar.review.convertor.product.ProductConvertToDTO;
import com.bahar.review.dto.ProductDTO;
import com.bahar.review.exception.NotFoundException;
import com.bahar.review.model.Product;
import com.bahar.review.repo.ProductDbRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProductServiceImpl implements ProductService{

    private final ProductDbRepository productDbRepository;
    private final DTOConvertToProduct dtoConvertToProduct;
    private final ProductConvertToDTO productConvertToDTO;


    public List<ProductDTO> getAllProducts() {
        return productDbRepository.findAll()
                .stream()
                .map(productConvertToDTO::convert)
                .collect(Collectors.toList());

    }

    public ProductDTO findById(Long id) {
        Product product = null;

        try {
            product = productDbRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("No product was found with id=" + id));
        } catch (NotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return productConvertToDTO.convert(product);

    }

//    public HashMap convertProductDTOTOHashMap(ProductDTO productDTO,Long id){
//
//
//        HashMap product = new HashMap(0);
//        if(id.equals(findById(id))) {
//            product.put(id.equals(findById(id)), productDTO.getName());
//        }
//        return (HashMap) product.get(id);
//
//    }

    public ProductDTO saveProduct(ProductDTO productDTO) {

        Product product = dtoConvertToProduct.convert(productDTO);
        Product productCreated = productDbRepository.save(product);

        return productConvertToDTO.convert(productCreated);

    }


    public ProductDTO findProductDtoById(ProductDTO productDtoDetails, Long id) {
        Product product = productDbRepository.findById(id).get();

        if (product != null) {
            Product updateSetInfo = dtoConvertToProduct.convert(productDtoDetails);
            product.setName(updateSetInfo.getName());
            product.setDescription(updateSetInfo.getDescription());
            product.setUpc(updateSetInfo.getUpc());

            Product updatedPaper = productDbRepository.save(product); // save in db

            return productConvertToDTO.convert(updatedPaper); // send productDto to view


        }
        return null;//todo throw exception
    }


    public void updateProductDescription(Long paperIds, String productDescription) {

        Product updateProductDescription = productDbRepository.findProductById(paperIds);
        if (updateProductDescription != null) {
            updateProductDescription.setDescription(productDescription);
            productDbRepository.save(updateProductDescription);
        } else {
            new NotFoundException("There is no Tag with this " + paperIds + " ");
        }
    }

    public void delete(Long id) {
        productDbRepository.deleteById(id);

    }
}
