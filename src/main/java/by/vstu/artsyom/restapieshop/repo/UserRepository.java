package by.vstu.artsyom.restapieshop.repo;

import by.vstu.artsyom.restapieshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}