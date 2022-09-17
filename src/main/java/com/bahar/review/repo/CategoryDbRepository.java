package com.bahar.review.repo;


import com.bahar.review.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDbRepository extends JpaRepository<Category, Long> {
}
