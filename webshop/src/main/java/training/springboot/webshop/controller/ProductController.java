package training.springboot.webshop.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import training.springboot.webshop.entity.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @GetMapping("/{id}")
    public Product get(@PathVariable long id) {
        return new Product(id, "test", new BigDecimal("9.99"), "This is a dummy product");
    }
}
