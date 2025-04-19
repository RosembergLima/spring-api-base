package com.spring.base.service;

import com.spring.base.dto.ProductDto;
import com.spring.base.entity.Product;
import com.spring.base.exception.ObjectNotFoundException;
import com.spring.base.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void save(ProductDto productDto){
    Product product = new Product();
    product.setDescription(productDto.getDescription());
    product.setId(productDto.getId());
    productRepository.save(product);
  }

  public List<Product> findAll(){
    return productRepository.findAll();
  }

  public Product findById(Integer id) {
    Optional<Product> product = productRepository.findById(id);
    return product.orElseThrow(() -> new ObjectNotFoundException(
        "Object not found! Id: " + id));
  }
}
