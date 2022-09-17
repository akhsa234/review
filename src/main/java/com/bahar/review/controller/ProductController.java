package com.bahar.review.controller;

import com.bahar.review.dto.ProductDTO;
import com.bahar.review.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProductController {

    private final ProductServiceImpl productService;

    //approved
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> loadAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO LoadProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO createProduct(@Valid @RequestBody ProductDTO product){

        return productService.saveProduct(product);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<ProductDTO> updatedAllInfo(@Valid @RequestBody ProductDTO productDtoDetails,
                                                     @PathVariable Long id) {
        ProductDTO product= productService.findProductDtoById(productDtoDetails,id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(Long id){
        productService.delete(id);
    }
}
