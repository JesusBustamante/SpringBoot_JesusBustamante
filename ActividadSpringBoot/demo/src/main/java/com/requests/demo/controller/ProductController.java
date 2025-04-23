package com.requests.demo.controller;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.requests.demo.model.Product;
import com.requests.demo.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {
    // Aquí usas inyecciónes de Dependencias 😁
    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/products")
    public List<Product> getProducts(
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String category) {
        // Aplica los filtros de minPrice, maxPrice y category, recuerda que pueden
        // aplicarse todos o ninguno
        return repo.findAll().stream()
                .filter(p -> minPrice == null || p.getPrice() >= minPrice)
                .filter(p -> maxPrice == null || p.getPrice() >= maxPrice)
                .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
                .toList();
    }


    @GetMapping("/products/stats")
    public Map<String, Double> getStats(
            @RequestParam(required = false) String category) {

        // Obtenga el listado de productos filtrados por categoría

        List<Product> filtrado = repo.findAll().stream() 
            .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
            .toList();

            DoubleSummaryStatistics statistics = filtrado.stream()
                .mapToDouble(Product::getPrice)
                .summaryStatistics();

            double totalValue = statistics.getSum();

        return Map.of(
                "count", (double) statistics.getCount(),
                "avgPrice", statistics.getAverage(),
                "minPrice", statistics.getMin(),
                "maxPrice", statistics.getMax(),
                "totalValue", totalValue);
    }
}
