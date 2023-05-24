package by.vstu.artsyom.restapieshop.repo;

import by.vstu.artsyom.restapieshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}