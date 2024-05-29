package online.gemfpt.BE.api;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import online.gemfpt.BE.Entity.Product;
import online.gemfpt.BE.Service.ProductServices;
import online.gemfpt.BE.model.ProductsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@SecurityRequirement(name="api")
@CrossOrigin("*")
public class ProductAPI {
    @Autowired
    ProductServices productServices;

    @PostMapping("products")
    public ResponseEntity creates (@RequestBody ProductsRequest productsRequest) {
        Product product = productServices.creates(productsRequest);
        return ResponseEntity.ok(product);
    }
    @DeleteMapping  ("products By ID")
    public ResponseEntity<Void> deleteProductID(@PathVariable Long id) {
        productServices.deleteID(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping  ("products By Barcode")
    public ResponseEntity<Void> deleteProductBarcode(@PathVariable Long barcode) {
        productServices.deleteByBarCode(barcode);
        return ResponseEntity.noContent().build();
    }
}
