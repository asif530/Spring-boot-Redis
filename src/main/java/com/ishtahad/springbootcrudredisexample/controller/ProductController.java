package com.ishtahad.springbootcrudredisexample.controller;

import com.ishtahad.springbootcrudredisexample.entity.Product;
import com.ishtahad.springbootcrudredisexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/addProductToRedis")
    public Product addProductToRedis(@RequestBody Product product){
        return service.saveToRedis(product);
    }

    @PostMapping("/addProductToDatabase")
    public Product addProductToDatabase(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    @GetMapping("/getProducts")
    @Cacheable(value = "products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }

    @GetMapping("/getProductsFromCache")
    public List<Product> findAllProductsFromCache(){
        return service.findAllFromChache();
    }

    @GetMapping("/getProductFromCache/{id}")
    public Product findAllProductByIdFromCache(@PathVariable int id){
        return service.findProductByIdFromChache(id);//(service.getProductById(id));
    }

    @GetMapping("/getProduct/{id}")
    @Cacheable(value = "product",key = "#id")
    public Product findAllProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @PutMapping("/updateProduct")
    @CachePut(value = "products",key="#product.id")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    @GetMapping("/populateChacheByProducts")
    public void populateCacheByProducts(){
         service.populateCacheByProducts();

    }

}
