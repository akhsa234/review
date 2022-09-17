package com.bahar.review.repo;

import com.bahar.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {

    public List<Review> findByProductId(String productId);

}
