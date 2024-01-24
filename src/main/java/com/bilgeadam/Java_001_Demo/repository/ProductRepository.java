package com.bilgeadam.Java_001_Demo.repository;

import com.bilgeadam.Java_001_Demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    /*
   # Ürün ismine göre ürünü bulunuz.
# Ürün isminin içerdiği harf veya kelimeye göre ürünü bulunuz.
# Belirli fiyat aralığındaki ürünleri listeleyiniz.
    */
    //codeium
    Optional<Product> findByProductName(String productName);
    Optional<Product> findByProductNameIgnoreCase(String productName);

    List<Product> findAllByProductNameLikeIgnoreCase(String productName);
    List<Product> findAllByProductNameContainingIgnoreCase(String productName);
    List<Product> findAllByProductPriceBetween(Double start, Double end);

    List<Product> findAllByProductPriceGreaterThan(Double price);
    List<Product> findAllByProductUnitInStockGreaterThan(Double stock);
    List<Product> findAllByProductPriceGreaterThanEqual(Double price);

    @Query("select count(p) from Product p where p.productCategory = ?1")
    Integer countByProductCategory(String category);

    @Query("select count(p) from Product p where p.productName = ?1")
    Integer countByProductName(String productName);

    boolean existsByProductCategory(String category);

    List<Product> findAllByProductCategoryIsNull();
    List<Product> findByProductCategoryStartingWithIgnoreCase(String category);

}
