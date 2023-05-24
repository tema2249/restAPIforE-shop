package by.vstu.artsyom.restapieshop.service;

import by.vstu.artsyom.restapieshop.entity.Cart;
import by.vstu.artsyom.restapieshop.entity.Product;
import by.vstu.artsyom.restapieshop.entity.User;
import by.vstu.artsyom.restapieshop.repo.CartRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class CartService {
    private ProductService productService;
    private CartRepository cartRepository;
    public Optional<Cart> findById(Long id){
        return cartRepository.findById(id);
    }
    public Cart addToCart(User user, Long product_id, int quantity){
        return new Cart(user, productService.findByID(product_id).get(), quantity);

    }

    public List<Cart> getAll(User user) {
        return cartRepository.findAll();

    }

    public List<Cart> getTakeAll(User user) {
        return cartRepository.findCartByUserAndTake(user, true);
    }

    public boolean delete(Long id) {
        cartRepository.delete(findById(id).get());
        return true;
    }

    public Cart update(Long id, Cart cart) {
        cartRepository.delete(findById(id).get());
        cartRepository.save(cart);
        return cart;

    }
}
