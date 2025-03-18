package com.example.nobsv2.product.services;

import com.example.nobsv2.product.ProductRepository;
import com.example.nobsv2.product.Query;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductByIdService implements Query<Integer, ProductDTO> {

  private final ProductRepository productRepository;

  public GetProductByIdService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public ResponseEntity<ProductDTO> execute(Integer id) {
    Optional<Product> product = productRepository.findById(id);

    if(product.isPresent()){
      return ResponseEntity.status(HttpStatus.OK).body(new ProductDTO(product.get()));
    }

    //TODO code the other usecase to throw an exception

    return null;
  }
}
