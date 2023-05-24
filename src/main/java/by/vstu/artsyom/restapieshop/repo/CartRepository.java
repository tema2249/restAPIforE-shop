package by.vstu.artsyom.restapieshop.repo;

import by.vstu.artsyom.restapieshop.entity.Cart;
import by.vstu.artsyom.restapieshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findCartByUserAndTake(User user, boolean take);
}