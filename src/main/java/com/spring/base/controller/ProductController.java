package com.spring.base.controller;

import com.spring.base.dto.ProductDto;
import com.spring.base.entity.Product;
import com.spring.base.service.ProductService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping
  public ResponseEntity<Void> save(@RequestBody ProductDto productDto){
    productService.save(productDto);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/all")
  public ResponseEntity<List<Product>> findAll(){
    var products = productService.findAll();
    return ResponseEntity.ok().body(products);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> findById(@PathVariable Integer id){
    var product = productService.findById(id);
    return ResponseEntity.ok().body(product);
  }
}
