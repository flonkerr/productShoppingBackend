package com.example.ProductsShopping.repository;

import com.example.ProductsShopping.entity.CartItem;
import com.example.ProductsShopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findCartItemByCartId(Long cartId);
    Optional<CartItem> findCartItemByCartIdAndProductId(Long cartId, Long productId);

    void DeleteByUser(User user);
}
