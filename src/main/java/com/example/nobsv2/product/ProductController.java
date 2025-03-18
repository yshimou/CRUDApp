package com.example.nobsv2.product;

import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import com.example.nobsv2.product.services.CreateProductService;
import com.example.nobsv2.product.services.DeleteProductService;
import com.example.nobsv2.product.services.GetProductByIdService;
import com.example.nobsv2.product.services.GetProductsService;
import com.example.nobsv2.product.services.UpdateProductService;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

  
  private final CreateProductService createProductService;

  
  private final GetProductsService getProductsService;

  
  private final UpdateProductService updateProductService;

  
  private final DeleteProductService deleteProductService;

  private final GetProductByIdService getProductByIDService;

    public ProductController(CreateProductService createProductService, GetProductsService getProductsService,
      UpdateProductService updateProductService, DeleteProductService deleteProductService, GetProductByIdService getProductByIDService) {
    this.createProductService = createProductService;
    this.getProductsService = getProductsService;
    this.updateProductService = updateProductService;
    this.deleteProductService = deleteProductService;
    this.getProductByIDService = getProductByIDService;
  }

  @PostMapping("/product")
  public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
    return createProductService.execute(product);
  }

  @GetMapping("/products")
  public ResponseEntity<List<ProductDTO>> getProducts() {
    return getProductsService.execute(null);
  }

  @GetMapping("/product/{id}")
  public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) {
    return getProductByIDService.execute(id);
  }

  @PutMapping("/product/{id}")
  public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
    Pair<Integer,Product> updateCommand = Pair.of(id,product);
    return updateProductService.execute(updateCommand);
  }

  @DeleteMapping("/product/{id}")
  public ResponseEntity<Void>  deleteProduct(@PathVariable Integer id) {
    return deleteProductService.execute(id);
  }

}
