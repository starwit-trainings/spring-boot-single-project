package training.springboot.webshop.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import training.springboot.webshop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
