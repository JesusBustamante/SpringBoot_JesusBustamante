package com.requests.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.requests.demo.model.Product;

@Repository
public class ProductRepository {
    // Agrega 20 products con datos de ejemplo
    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        for(long i = 1; i <= 20; i++) {
            products.add(new Product(i, "Producto " + i, i % 2 == 0 ?
            "Tecnología" : "Hogar", 10.0 + i * 5, (int) (i * 2)));
        }
    }

    public List<Product> findAll() { return products; }
}
