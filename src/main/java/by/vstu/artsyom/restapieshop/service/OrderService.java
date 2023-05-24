package by.vstu.artsyom.restapieshop.service;

import by.vstu.artsyom.restapieshop.entity.*;
import by.vstu.artsyom.restapieshop.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;

    public Order create(User user,String fullAddress){
        List<Cart> carts = cartService.getTakeAll(user);
        if (carts.isEmpty()){
            return null;
        }
        Order order = new Order(user, fullAddress);
        for (Cart cart : carts){
            OrderDetails orderDetails = new OrderDetails(order, cart.getProduct(), cart.getQuantity());
            order.getOrderDetails().add(orderDetails);
        }

        return order;
    }

    public Order findByID(Long id){
        return orderRepository.findById(id).get();
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public List<Order> getOrdersUsers(User user){
        return orderRepository.findOrdersByUser(user);
    }

    public boolean delete(Long id, User user) {
        Order order = orderRepository.findOrderByIdAndUser(id, user);
        if (order == null){
            return  false;
        }
        orderRepository.delete(order);
        return true;
    }

    public Optional<Order> getOne(Long id) {
        return orderRepository.findById(id);
    }
}
