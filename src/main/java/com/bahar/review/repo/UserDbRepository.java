package com.bahar.review.repo;


import com.bahar.review.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDbRepository extends JpaRepository<User, Long> {

    User  findUserById(Long paperIds);
}
