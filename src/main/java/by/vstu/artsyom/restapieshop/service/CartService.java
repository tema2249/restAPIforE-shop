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
    private UserService userService;
    private CartRepository cartRepository;
    public Optional<Cart> findById(Long id){
        return cartRepository.findById(id);
    }
    public Cart addToCart(Long user_id, Long product_id, int quantity){
        Optional<User> user = userService.findById(user_id);
        Optional<Product> product = productService.findByID(product_id);
        if (user.isPresent() == false || product.isPresent() == false){
            return null;
        }
        User user1 = user.get();
        Cart cart = new Cart(user.get(), product.get(), quantity);
        return cart;

    }

    public List<Cart> getAll() {
        return cartRepository.findAll();

    }

    public List<Cart> getTakeAll(User user) {
        return cartRepository.findCartByUserAndTake(user, true);
    }

    public boolean delete(Long id) {
        cartRepository.delete(findById(id).get());
        return true;
    }

    public Optional<Cart> update(Long id, int quantity) {
        Optional<Cart> cart = findById(id);
        if (cart.isPresent() == false){
            return null;
        }
        cart.get().setQuantity(quantity);
        cartRepository.save(cart.get());
        return cart;

    }

}
