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
        product0.get().setTitle(product.getTitle());
        product0.get().setPrice(product.getPrice());
        product0.get().setDetails(product.getDetails());
        productRepository.save(product0.get());
        return product0.get();

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
