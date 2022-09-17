package com.bahar.review.repo;


import com.bahar.review.model.Authority;
import com.bahar.review.model.AuthorityEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {

    Authority findByName(AuthorityEnum name);
}
