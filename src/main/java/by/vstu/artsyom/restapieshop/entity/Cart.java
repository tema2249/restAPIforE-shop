package by.vstu.artsyom.restapieshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "cart")
@RequiredArgsConstructor
@Getter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "take")
    private Boolean take;

    public Boolean getTake() {
        return take;
    }

    public void setTake(Boolean take) {
        this.take = take;
    }

    public Cart(User user, Product product, int quantity){
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    @PrePersist
    private void init(){
        take = true;
    }


}