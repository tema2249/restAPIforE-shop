package by.vstu.artsyom.restapieshop.service;

import by.vstu.artsyom.restapieshop.entity.User;
import by.vstu.artsyom.restapieshop.repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class UserService{
    private final UserRepository userRepository;

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
