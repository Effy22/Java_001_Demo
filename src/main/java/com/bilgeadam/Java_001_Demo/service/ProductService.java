package com.bilgeadam.Java_001_Demo.service;

import com.bilgeadam.Java_001_Demo.entity.Product;
import com.bilgeadam.Java_001_Demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // yada aşağıda üstüne @Autowired diyebilirdik ama eski
public class ProductService implements IService<Product,Long>{

    private final ProductRepository productRepository;
    @Override
    public Product save(Product product) {
        return productRepository.save(Product.builder()
                .productName(product.getProductName())
                .productCategory(product.getProductCategory())
                .productPrice(product.getProductPrice())
                .productUnitInStock(product.getProductUnitInStock())
                .productDescription(product.getProductDescription())
                .build());
    }
    @Override
    public Product update(Product product) {
        Optional<Product> product1 = productRepository.findById(product.getId());

        if(product1.isEmpty()){
            //exception fırlatıyorum.
        }
        return productRepository.save(product);
    }

    @Override
    public Iterable<Product> saveAll(Iterable<Product> t) {
        return null;
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findByProductName(String productName){
        if(productName.equalsIgnoreCase(productRepository.findByProductName(productName).get().getProductName())){
            return productRepository.findByProductName(productName);
        }
        return null;
    }

    public Optional<Product> findByProductNameIgnoreCase(String productName){
        return productRepository.findByProductNameIgnoreCase(productName);
    }
    public  List<Product> findAllByProductNameLikeIgnoreCase(String productName){
        return productRepository.findAllByProductNameLikeIgnoreCase(productName);
    }

    public List<Product> findAllByProductNameContainingIgnoreCase(String productName){
        return productRepository.findAllByProductNameContainingIgnoreCase(productName);
    }

    public List<Product> findAllByProductPriceBetween(Double start, Double end){
        return productRepository.findAllByProductPriceBetween(start,end);
    }

    public Integer countByProductCategory(String category){
        return productRepository.countByProductCategory(category);
    }

    public List<Product> findAllByProductPriceGreaterThan(Double price){
        return productRepository.findAllByProductPriceGreaterThan(price);
    }

    public List<Product> findAllByProductUnitInStockGreaterThan(Double stock){
        return productRepository.findAllByProductUnitInStockGreaterThan(stock);
    }

    public List<Product> findAllByProductPriceGreaterThanEqual(Double price){
        return productRepository.findAllByProductPriceGreaterThanEqual(price);
    }
    public Integer countByProductName(String productName){
        return productRepository.countByProductName(productName);
    }

    public boolean existsByProductCategory(String category){
        return productRepository.existsByProductCategory(category);
    }
    public List<Product> findAllByProductCategoryIsNull(){
        return productRepository.findAllByProductCategoryIsNull();
    }
    public List<Product> findByProductCategoryStartingWithIgnoreCase(String category){
        return productRepository.findByProductCategoryStartingWithIgnoreCase(category);
    }




}
