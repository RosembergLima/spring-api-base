package com.spring.base.controller;

import com.spring.base.dto.ProductDto;
import com.spring.base.entity.Product;
import com.spring.base.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

  @Operation(summary = "Create a new product", description = "Adds a new product to the database.")
  @ApiResponse(responseCode = "200", description = "Product created successfully")
  @PostMapping
  public ResponseEntity<Void> save(@RequestBody ProductDto productDto){
    productService.save(productDto);
    return ResponseEntity.ok().build();
  }

  @Operation(summary = "Get all products", description = "Returns a list of all registered products.")
  @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of products")
  @GetMapping("/all")
  public ResponseEntity<List<Product>> findAll(){
    var products = productService.findAll();
    return ResponseEntity.ok().body(products);
  }

  @Operation(summary = "Get product by ID", description = "Retrieves a specific product by its unique ID.")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Product found"),
      @ApiResponse(responseCode = "404", description = "Product not found")
  })
  @GetMapping("/{id}")
  public ResponseEntity<Product> findById(@PathVariable Integer id){
    var product = productService.findById(id);
    return ResponseEntity.ok().body(product);
  }
}
