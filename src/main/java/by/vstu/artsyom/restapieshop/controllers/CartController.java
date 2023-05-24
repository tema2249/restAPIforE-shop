package by.vstu.artsyom.restapieshop.controllers;

import by.vstu.artsyom.restapieshop.entity.Cart;
import by.vstu.artsyom.restapieshop.entity.User;
import by.vstu.artsyom.restapieshop.repo.ProductRepository;
import by.vstu.artsyom.restapieshop.service.CartService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final ProductRepository productRepository;
    @PostMapping
    public ResponseEntity<Cart> add(@RequestBody Long product_id, @RequestBody int quantity){
        User user = new User();
        Cart cart = cartService.addToCart(user, product_id, quantity);
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAll(){
        User user = new User();
        List<Cart> carts = cartService.getAll(user);
        if (!carts.isEmpty()) {
            return new ResponseEntity<>(carts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteNomenclature(@RequestBody Long id) {
        boolean deleted = cartService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> update(@RequestBody Long id, @RequestBody Cart cart){
        if (cartService.update(id, cart) != null ){
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
