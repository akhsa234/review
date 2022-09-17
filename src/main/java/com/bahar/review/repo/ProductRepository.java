package com.bahar.review.repo;


import com.bahar.review.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * DAO repository for working with {@link Product}.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

  Optional<Product> findById(String productId);

    /**
     * find {@link Product}s from database by name
     */
//    @Query("SELECT p FROM Product p WHERE "
//            + "p.name LIKE '%' || :searchString || '%'")
    @Query("SELECT p FROM Product p WHERE "
            + "p.name LIKE '%' ")
    List<Product> findByName(@Param("searchString") String searchString);

    /**
     * find {@link Product}s from database by type
     */
    @Query("SELECT p FROM Product p WHERE "
            + "p.type LIKE '%'")
    List<Product> findByType(@Param("searchString") String searchString);
}
