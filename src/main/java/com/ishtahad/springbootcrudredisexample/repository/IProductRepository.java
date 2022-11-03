package com.ishtahad.springbootcrudredisexample.repository;

import com.ishtahad.springbootcrudredisexample.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
}
