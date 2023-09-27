package training.springboot.webshop.controller;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import training.springboot.webshop.entity.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable long id) {
        Product dummyProduct = new Product(id, "test", new BigDecimal("9.99"), "This is a dummy product");
        return new ResponseEntity<Product>(dummyProduct, HttpStatus.OK);
    }
}
