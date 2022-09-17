package com.bahar.review.controller;



import com.bahar.review.dto.ProductDTO;
import com.bahar.review.dto.ReviewDto;
import com.bahar.review.exception.ConfigException;
import com.bahar.review.exception.NotFoundException;
import com.bahar.review.service.ProductServiceImpl;
import com.bahar.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping(path = "/bahar/api/product")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ReviewProductController {


    private final ProductServiceImpl productService;
    private final ReviewService reviewService;

//    public ProductController(ProductService productService, ReviewService reviewService) {
//        this.productService = productService;
//        this.reviewService = reviewService;
//    }

    @GetMapping(value = "/{productId}")
    @Cacheable(value = "products", key = "#productId")
    public ResponseEntity getOne(@PathVariable @NonNull String productId) throws NotFoundException,
            ConfigException, InterruptedException, ExecutionException, TimeoutException {

        HashMap product = new HashMap(0);


        CompletableFuture futureComputationResults = CompletableFuture
                .supplyAsync(() -> {
            return productService.findById(Long.valueOf(productId));

        }).thenAcceptAsync(results -> setProductValue(product,results));

        ReviewDto reviewInfo = reviewService.getReviewsInfo(productId);

        futureComputationResults.get();

        if (product.isEmpty()) {
            throw new NotFoundException("product with this specific id was not found = " + productId);
        }

        HashMap result = new HashMap();
        result.put("product info ", product);
        result.put("review info ", reviewInfo);
        return ResponseEntity.ok(result);

    }

    private void setProductValue( HashMap map, ProductDTO result) { // is it correct???
        map.clear();
        map.putAll((Map) result);
    }

}


