package training.springboot.webshop.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import training.springboot.webshop.persistence.ProductRepository;

@SpringBootTest
@ActiveProfiles("dev")
public class DataLoaderTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void verifyTestData() {
        long productCount = productRepository.count();
        Assertions.assertEquals(productCount, 46);
    }
    
}
