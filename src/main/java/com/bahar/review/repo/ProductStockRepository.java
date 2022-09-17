package com.bahar.review.repo;


import com.bahar.review.model.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO repository for working with {@link ProductStock}.
 */
@Repository
public interface ProductStockRepository extends JpaRepository<ProductStock, String> {

    ProductStock findByStockIdAndProductId(String stockId, String productId);
}
