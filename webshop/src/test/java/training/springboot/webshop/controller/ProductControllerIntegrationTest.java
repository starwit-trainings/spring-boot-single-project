package training.springboot.webshop.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class ProductControllerIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @BeforeAll
    public void setup() throws Exception {

        String testProduct = """
                {
                    "name": "test",
                    "price": "9.99",
                    "description": "It's just a test..."
                }
                """;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
                
        restTemplate
            .postForEntity("/product", new HttpEntity<String>(testProduct, headers), String.class);
    }

    @Test
    public void getExistingProduct() throws Exception {

        ResponseEntity<String> response = restTemplate
            .getForEntity("/product/1", String.class);

        assertTrue(response.getStatusCode().is2xxSuccessful());

    }

}
