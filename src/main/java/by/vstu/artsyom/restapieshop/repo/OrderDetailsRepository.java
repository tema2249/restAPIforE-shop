package by.vstu.artsyom.restapieshop.repo;

import by.vstu.artsyom.restapieshop.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}