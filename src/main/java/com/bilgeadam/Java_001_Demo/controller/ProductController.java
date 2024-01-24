package com.bilgeadam.Java_001_Demo.controller;

import com.bilgeadam.Java_001_Demo.entity.Product;
import com.bilgeadam.Java_001_Demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // http://localhost:8080/product/save?productName=TV&productCategory=Elektronik&productPrice=1000&productUnitlnStock=11&productDescription=samsun_tv

    @GetMapping("/save")
    public Product save(Product product){
        return productService.save(product);
    }
    @GetMapping("/find-all")
    public List<Product> findAll(){
        return productService.findAll();
    }

    // http://localhost:8080/product/find-by-id?id=2
    @GetMapping("/find-by-id")
    public Optional<Product> findById(Long id){
        return productService.findById(id);
    }

    @GetMapping("/update") //PutMapping ile yapmaya calisirsam, PUT request yollarsam 405(Forbidden) dönecektir.
    public Product update(Product product){
        return productService.update(product);
    }
    //http://localhost:8080/product/find-by-productname?productName=tablet

    @GetMapping("/find-by-product-name")
    public Optional<Product> findByProductName(String productName){
        return productService.findByProductName(productName);
    }

    @GetMapping("/find-by-product-name-ignore-case")
    public Optional<Product> findByProductNameIgnoreCase(String productName){
        return productService.findByProductNameIgnoreCase(productName);
    }
    @GetMapping("/find-all-by-product-name-like-ignore-case") //-> Bunun yerine containing kullanmak gerekiyor.
    public  List<Product> findAllByProductNameLikeIgnoreCase(String productName){
        return productService.findAllByProductNameLikeIgnoreCase(productName);
    }

    @GetMapping("/find-all-by-product-name-containing-ignore-case") //http://localhost:8080/product/find-all-by-product-name-containing-ignore-case?name=Be
    public List<Product> findAllByProductNameContainingIgnoreCase(String name){
        return productService.findAllByProductNameContainingIgnoreCase(name);
    }

    @GetMapping("/find-all-by-product-price-between")
    public List<Product> findAllByProductPriceBetween(Double start, Double end){
        return productService.findAllByProductPriceBetween(start,end);
    }

    @GetMapping("/count-by-product-category")
    public Integer countByProductCategory(String category){
        return productService.countByProductCategory(category);
    }
    @GetMapping("/find-all-by-product-price-greater-than")
    public List<Product> findAllByProductPriceGreaterThan(Double price){
        return productService.findAllByProductPriceGreaterThan(price);
    }

    @GetMapping("/find-all-by-product-unit-in-stock-greater-than")
    public List<Product> findAllByProductUnitInStockGreaterThan(Double stock){
        return productService.findAllByProductUnitInStockGreaterThan(stock);
    }
    @GetMapping("/find-all-by-product-price-greater-than-equal")
    public List<Product> findAllByProductPriceGreaterThanEqual(Double price){
        return productService.findAllByProductPriceGreaterThanEqual(price);
    }



    @GetMapping("/count-by-product-name")
    public Integer countByProductName(String productName){
        return productService.countByProductName(productName);
    }

    @GetMapping("/exists-by-product-category")
    public boolean existsByProductCategory(String category){
        return productService.existsByProductCategory(category);
    }

    @GetMapping("/find-all-by-product-category-is-null")
    public List<Product> findAllByProductCategoryIsNull(){
        return productService.findAllByProductCategoryIsNull();
    }
    @GetMapping("/find-by-product-category-starting-with-ignore-case")
    public List<Product> findByProductCategoryStartingWithIgnoreCase(String category){
        return productService.findByProductCategoryStartingWithIgnoreCase(category);
    }

}
