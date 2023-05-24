package by.vstu.artsyom.restapieshop.service;

import by.vstu.artsyom.restapieshop.entity.Product;
import by.vstu.artsyom.restapieshop.repo.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public Product create(Product product) {
        //Product product = new Product();
        //product.setTitle(title);
        productRepository.save(product);
        return product;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getOne(Long id){
        return findByID(id).get();
    }

    public Product update(Long id, Product product) {
        Optional<Product> product0 = findByID(id);
        if (product0.isPresent() == false) {
            return null;
        }
        productRepository.save(product);
        return product;

    }

    public boolean delete(Long id) {
        Optional<Product> product0 = findByID(id);
        if (product0.isPresent() == false) {
            return false;
        }
        productRepository.delete(product0.get());
        return true;
    }

    public Optional<Product> findByID(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product;
    }
}
