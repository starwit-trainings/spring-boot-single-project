package training.springboot.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import training.springboot.webshop.entity.Product;
import training.springboot.webshop.persistence.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable long id) {
        return new ResponseEntity<Product>(
            productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> post(@RequestBody Product product) {
        if (productRepository.existsById(product.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "entity with id " + product.getId() + " exists");
        }
        return new ResponseEntity<Product>(productRepository.save(product), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        if (!productRepository.existsById(product.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(productRepository.save(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable long id) {
        Product productForDeletion = productRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        productRepository.delete(productForDeletion);
        return new ResponseEntity<Product>(productForDeletion, HttpStatus.OK);
    }

}
