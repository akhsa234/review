package com.bahar.review.repo;


import com.bahar.review.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * DAO repository for working with {@link Store}.
 */
@Repository
public interface StoreRepository extends JpaRepository<Store, String> {

    /**
     * find {@link Store} from database by name
     */
    @Query("SELECT s FROM Store s WHERE "
            + "s.name LIKE '%' ")
    Store findByName(@Param("searchString") String searchString);
}
