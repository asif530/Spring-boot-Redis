package com.ishtahad.springbootcrudredisexample.service;

import com.ishtahad.springbootcrudredisexample.entity.Product;
import com.ishtahad.springbootcrudredisexample.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    public static final String HASH_KEY = "products";

    @Autowired
    private RedisTemplate template;


    public Product saveProduct(Product product){
         return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    public Product saveToRedis(Product product){
        template.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }

    public List<Product> getProducts(){
        System.out.println("From Database");
        return productRepository.findAll();
    }

    public List<Product> getProductsByQuery(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        System.out.println("From Database");
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findAllFromChache(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductByIdFromChache(int id){
        return (Product) template.opsForHash().get(HASH_KEY,id);
    }



    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        if(existingProduct != null){
            existingProduct.setName(product.getName());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setPrice(product.getPrice());
        }
        return productRepository.save(existingProduct);
    }

    public void populateCacheByProducts(){
        List<Product> productList = productRepository.findAll();
        template.opsForList().leftPushAll(HASH_KEY,productList);
    }




}
