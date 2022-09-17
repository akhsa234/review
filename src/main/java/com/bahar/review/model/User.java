package com.bahar.review.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "\"user\"")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {//extends BaseEntity {//version1

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "authority_id")
    private Authority authority;

    @OneToOne(
            mappedBy = "user",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Cart cart;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    private String phone;

    private String firstName;

    private String lastName;

    private LocalDateTime createDate;

    private String avatar;


    public User(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public User(final Long id, final String username, final String password) {
        this.setId(id);
        this.username = username;
        this.password = password;
    }


    public Cart getCart() {
        return this.cart;
    }

    public void createCart() {
        this.cart = new Cart();
        cart.setUser(this);
    }

    public void removeCart() {
        if (Objects.nonNull(cart)) {
            cart.setUser(null);
        }
        this.cart = null;
    }
}
