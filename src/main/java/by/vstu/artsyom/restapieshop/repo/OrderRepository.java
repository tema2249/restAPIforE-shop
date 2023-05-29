package by.vstu.artsyom.restapieshop.repo;

import by.vstu.artsyom.restapieshop.entity.Order;
import by.vstu.artsyom.restapieshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByUser(Optional<User> user);

    Order findOrderByIdAndUser(Long id, User user);
}