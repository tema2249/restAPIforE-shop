package by.vstu.artsyom.restapieshop.entity;

import by.vstu.artsyom.restapieshop.entity.Product;
import by.vstu.artsyom.restapieshop.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;



    @Column(name = "full_address")
    private String fullAddress;

    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetails;

    private LocalDateTime dateOfCreated;

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }



    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @PrePersist
    private void init(){
        dateOfCreated = LocalDateTime.now();
    }

    public Order(User user, String fullAddress){
        this.user = user;
        this.fullAddress = fullAddress;
    }

}