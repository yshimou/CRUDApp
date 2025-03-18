package com.example.nobsv2.product.services;

import com.example.nobsv2.product.Command;
import com.example.nobsv2.product.ProductRepository;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<Pair<Integer, Product>, ProductDTO> {

  private final ProductRepository productRepository;

  public UpdateProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public ResponseEntity<ProductDTO> execute(Pair<Integer, Product> updateCommand) {
    Integer inpuId = updateCommand.getFirst();
    Product inputProduct = updateCommand.getSecond();
    Optional<Product> optionalProduct =  productRepository.findById(inpuId);

    if(optionalProduct.isPresent()){
      inputProduct.setId(inpuId);
      productRepository.save(inputProduct);
      return ResponseEntity.status(HttpStatus.OK).body(new ProductDTO(inputProduct));
    }

    //TODO add exception instead of returning null
    return null;
  }
}
