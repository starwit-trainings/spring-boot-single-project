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
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
@ActiveProfiles("default")
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
        headers.setBasicAuth("admin", "password");
                
        restTemplate
            .postForEntity("/product", new HttpEntity<String>(testProduct, headers), String.class);
    }

    @Test
    public void getExistingProduct() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("user", "password");

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        
        ResponseEntity<String> response = restTemplate
            .exchange("/product/1", HttpMethod.GET, httpEntity, String.class);

        assertTrue(response.getStatusCode().is2xxSuccessful());

    }

}
