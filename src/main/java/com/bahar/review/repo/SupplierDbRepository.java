package com.bahar.review.repo;


import com.bahar.review.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDbRepository extends JpaRepository<Supplier,Long> {
}
