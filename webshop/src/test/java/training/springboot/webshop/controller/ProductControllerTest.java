package training.springboot.webshop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getProduct() throws Exception {
        String testProduct = """
                {
                    "name": "test",
                    "price": "9.99",
                    "description": "It's just a test..."
                }
                """;

        mockMvc.perform(
            MockMvcRequestBuilders
                .post("/product")
                .content(testProduct)
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isCreated());

        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/product/1")
        ).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("test"));

        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/product/2")
        ).andExpect(MockMvcResultMatchers.status().isNotFound()).andReturn().getResponse();

    }
    
}
