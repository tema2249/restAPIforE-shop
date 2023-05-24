package by.vstu.artsyom.restapieshop.controllers;

import by.vstu.artsyom.restapieshop.entity.Order;
import by.vstu.artsyom.restapieshop.entity.User;
import by.vstu.artsyom.restapieshop.service.OrderService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@Data
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAll(@RequestBody User user){
        List<Order> orders = orderService.getOrdersUsers(user);
        if (!orders.isEmpty()) {
            //IsEmpty - проверяет, является ли строка пустой ("") или значение null.
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOne(@PathVariable Long id) {
        Optional<Order> order = orderService.getOne(id);
        if (order.isPresent()) {
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody User user, @RequestBody String fullAddress){
        Order order = orderService.create(user, fullAddress);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestBody User user, @PathVariable Long id) {
        boolean deleted = orderService.delete(id, user);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
