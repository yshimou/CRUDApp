package com.example.nobsv2.product.services;

import com.example.nobsv2.product.Command;
import com.example.nobsv2.product.ProductRepository;
import com.example.nobsv2.product.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductService implements Command<Integer, Void> {

  private final ProductRepository productRepository;

  public DeleteProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public ResponseEntity<Void> execute(Integer id) {
    Optional<Product> product = productRepository.findById(id);

    if(product.isPresent()){
      productRepository.deleteById(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //TODO exception
    return null;

  }
}
