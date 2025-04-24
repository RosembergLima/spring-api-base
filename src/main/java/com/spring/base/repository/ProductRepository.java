package com.spring.base.repository;

import com.spring.base.entity.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

  Product save(Product product);

  List<Product> findAll();

  Optional<Product> findById(Integer id);
}
