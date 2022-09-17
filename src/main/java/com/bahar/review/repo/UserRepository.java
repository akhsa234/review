package com.bahar.review.repo;

import com.bahar.review.model.AuthorityEnum;
import com.bahar.review.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO repository for working with {@link User}.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * find {@link User} from database by name
     */
    User findByUsername(String username);

    /**
     * find {@link User} from database by role
     */
    List<User> findByAuthorityName(AuthorityEnum name);

    /**
     * Find users by {@link AuthorityEnum}.
     */
    List<User> findByRole(AuthorityEnum role);

    /**
     * Load and return current user from context.
     */
    User getCurrentUser();

}
