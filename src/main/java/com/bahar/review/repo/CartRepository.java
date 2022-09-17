package com.bahar.review.repo;


import com.bahar.review.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CartRepository extends JpaRepository<Cart, String> {
}
