package com.akash.ecommerce.service;

import com.akash.ecommerce.model.Product;
import com.akash.ecommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product) {
        Product existing = repo.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setName(product.getName());
        existing.setDesc(product.getDesc());
        existing.setBrand(product.getBrand());
        existing.setPrice(product.getPrice());
        existing.setCategory(product.getCategory());
        existing.setReleaseDate(product.getReleaseDate());
        existing.setAvailable(product.isAvailable());
        existing.setQuantity(product.getQuantity());
        return repo.save(existing);
    }
}
