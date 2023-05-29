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
import java.util.Optional;

@RestController
@Data
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final ProductRepository productRepository;
    @PostMapping
    public ResponseEntity<Cart> add(@RequestBody Long user_id, @RequestBody Long product_id, @RequestBody int quantity){
        Cart cart = new Cart();
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAll(){
        List<Cart> carts = cartService.getAll();
        if (!carts.isEmpty()) {
            return new ResponseEntity<>(carts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Long id) {
        boolean deleted = cartService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Cart> update(@RequestBody Long id, @RequestBody int quantity){
        Optional<Cart> cart = cartService.update(id, quantity);
        if (cart.isPresent() ){
            return new ResponseEntity<>(cart.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
