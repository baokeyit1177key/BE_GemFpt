package online.gemfpt.BE.Service;

import online.gemfpt.BE.Entity.Product;
import online.gemfpt.BE.Repository.ProductsRepository;
import online.gemfpt.BE.model.ProductsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void deleteID(Long id ) {
        productsRepository.deleteById(id);
    }
    public void deleteByBarCode(Long barcode) {
        productsRepository.deleteById(barcode);
    }


}
