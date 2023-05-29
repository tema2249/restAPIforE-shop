package by.vstu.artsyom.restapieshop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String login;
    private String name;
    private String email;
    private String password;
    public User(String login, String name){
        this.login = login;
        this.name = name;
    }
}