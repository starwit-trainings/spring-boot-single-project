package training.springboot.webshop.persistence;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import training.springboot.webshop.entity.Product;

@Component
public class ProductCatalog {

    private Map<Long, Product> productMap = new HashMap<>();
    private long autoIncrement = 0;
    
    public Product getById(long id) throws EntityNotFoundException {
        Product product = productMap.get(id);
        if (product == null) {
            throw new EntityNotFoundException();
        }
        return product;
    }

    public Product save(Product product) throws EntityExistingException {
        if (productMap.containsKey(product.getId())) {
            throw new EntityExistingException();
        }
        product.setId(autoIncrement);
        productMap.put(product.getId(), product);
        autoIncrement++;
        return product;
    }

    public Product update(Product product) throws EntityNotFoundException {
        if (!productMap.containsKey(product.getId())) {
            throw new EntityNotFoundException();
        }
        productMap.put(product.getId(), product);
        return product;
    }

    public Product delete(long id) throws EntityNotFoundException {
        Product deletedProduct = productMap.remove(id);
        if (deletedProduct == null) {
            throw new EntityNotFoundException();
        }
        return deletedProduct;
    }

    public class EntityExistingException extends Exception {}

    public class EntityNotFoundException extends Exception {}

}
