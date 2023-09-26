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
import training.springboot.webshop.persistence.ProductCatalog;
import training.springboot.webshop.persistence.ProductCatalog.EntityExistingException;
import training.springboot.webshop.persistence.ProductCatalog.EntityNotFoundException;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductCatalog productCatalog;
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable long id) {
        try {
            return new ResponseEntity<Product>(productCatalog.getById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Product> post(@RequestBody Product product) {
        try {
            Product savedProduct = productCatalog.save(product);
            return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
        } catch (EntityExistingException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "entity with id " + product.getId() + " exists");
        }
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        try {
            return new ResponseEntity<Product>(productCatalog.update(product), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable long id) {
        try {
            return new ResponseEntity<Product>(productCatalog.delete(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
