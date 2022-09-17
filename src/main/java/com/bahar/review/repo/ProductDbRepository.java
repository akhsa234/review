package com.bahar.review.repo;


import com.bahar.review.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource(exported = true, path = "product-repo")
public interface ProductDbRepository extends JpaRepository<Product, Long> {

    Product  findProductById(Long paperIds);

//    Product findById(Long id);
//
//  //  @RestResource(path = "findProductByName")
//  //  Optional<Product> findBookByNameContaining(@Param("productName") String name);
//
//
////    @RestResource(exported = false)
//    void deleteAllInBatch();
//
// //   @RestResource(exported = false)
//    void deleteById(Long id);
//
//
////    @RestResource(exported = false)
//    void delete(Product entity);

}
