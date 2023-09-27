package training.springboot.webshop.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jayway.jsonpath.JsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public void setup() throws Exception {

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

    }

    @Test
    public void getExistingProduct() throws Exception {

        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/product/1")
        ).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("test"));

    }

    @Test
    public void getNotExistingProduct() throws Exception {

        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/product/2")
        ).andExpect(MockMvcResultMatchers.status().isNotFound()).andReturn().getResponse();

    }

    @Test
    public void addNewProduct() throws Exception {

        String test2Product = """
                {
                    "name": "test2",
                    "price": "29.99",
                    "description": "It's just the second test..."
                }
                """;

        mockMvc.perform(
            MockMvcRequestBuilders
                .post("/product")
                .content(test2Product)
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void updateProduct() throws Exception {

        String updatedProduct = """
                {
                    "id": 1,
                    "name": "test",
                    "price": "999.99",
                    "description": "It's just a test..."
                }
                """;

        mockMvc.perform(
            MockMvcRequestBuilders
                .put("/product")
                .content(updatedProduct)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("999.99"));

        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/product/1")
        ).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("999.99"));

    }

    @Test
    public void deleteProduct() throws Exception {
        String test3Product = """
                {
                    "name": "test3",
                    "price": "39.99",
                    "description": "Third time's the charme..."
                }
                """;

        String jsonResponse = mockMvc.perform(
            MockMvcRequestBuilders
                .post("/product")
                .content(test3Product)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isCreated())
        .andReturn().getResponse().getContentAsString();

        String test3Id = JsonPath.read(jsonResponse, "$.id").toString();

        mockMvc.perform(
            MockMvcRequestBuilders
                .delete("/product/" + test3Id)
        ).andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/product/" + test3Id)
        ).andExpect(MockMvcResultMatchers.status().isNotFound());

    }
    
}
