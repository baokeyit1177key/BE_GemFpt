package online.gemfpt.BE.Service;

import jakarta.persistence.EntityNotFoundException;
import online.gemfpt.BE.Entity.Product;
import online.gemfpt.BE.Repository.ProductsRepository;
import online.gemfpt.BE.model.ProductsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {
    @Autowired
    ProductsRepository productsRepository;

    public Product creates(ProductsRequest productsRequest) {
        Product product = new Product();
        product.setName(productsRequest.getName());
        product.setDescriptions(productsRequest.getDescriptions());
        product.setCategory(productsRequest.getCategory());
        product.setPrice(productsRequest.getPrice());
        product.setPriceRate(productsRequest.getPriceRate());
        product.setStock(productsRequest.getStock());
        product.setUrl(productsRequest.getUrl());
        product.setBarcode(productsRequest.getBarcode());


        return productsRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }


    public Product getProductByBarcode(Long barcode) {
        Optional<Product> optionalProduct = productsRepository.findById(barcode);
        return optionalProduct.orElse(null);
    }


    public Product updateProductByBarcode(ProductsRequest productsRequest) {
        Optional<Product> optionalProduct = productsRepository.findByBarcode(productsRequest.getBarcode());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productsRequest.getName());
            product.setDescriptions(productsRequest.getDescriptions());
            product.setCategory(productsRequest.getCategory());
            product.setPrice(productsRequest.getPrice());
            product.setPriceRate(productsRequest.getPriceRate());
            product.setStock(productsRequest.getStock());
            product.setUrl(productsRequest.getUrl());
            product.setBarcode(productsRequest.getBarcode());

            return productsRepository.save(product);
        } else {
            return null;
        }
    }

    public Product toggleProductActive(String barcode) {
        Product product = productsRepository.findByBarcode(barcode)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        product.setActive(!product.isActive()); // Đảo ngược trạng thái hiện tại
        return productsRepository.save(product);
    }
}


