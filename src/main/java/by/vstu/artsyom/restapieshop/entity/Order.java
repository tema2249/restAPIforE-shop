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
@Setter
@Getter
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

    @PrePersist
    private void init(){
        dateOfCreated = LocalDateTime.now();
    }

    public Order(User user, String fullAddress){
        this.user = user;
        this.fullAddress = fullAddress;
    }

}