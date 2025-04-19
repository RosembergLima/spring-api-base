package com.spring.base.repository;

import com.spring.base.entity.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
  private final List<Product> products = new ArrayList<>();

  public void save(Product product){
    products.add(product);
  }

  public List<Product> findAll(){
    return products;
  }

  public Optional<Product> findById(Integer id) {
    return products.stream().filter(product ->
        Objects.equals(product.getId(), id)).findFirst();
  }
}
