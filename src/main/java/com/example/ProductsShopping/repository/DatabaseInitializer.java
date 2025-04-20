package com.example.ProductsShopping.repository;

import com.example.ProductsShopping.entity.Product;
import com.example.ProductsShopping.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {

        if (productRepository.count() == 0) {
            User user = createUser("timur", "mammedov", "timur@example.com", "timur", "timur");

            List<Product> products = Arrays.asList(
                    createProduct("product1", "ModelA", "Category1", "description", 150.0, 5, "")
            );

            productRepository.saveAll(products);

            System.out.println("База данных успешно заполнена начальными данными.");
        } else {
            System.out.println("База данных уже содержит данные. Инициализация пропущена.");
        }
    }

    private User createlser (String name, String surname, String email, String username, String password) {
        User user = new User();
        user.setName(name);
        user.setSurname (surname);
        user.setEmail(email);
        user.setUsername (username);
        user.setPassword(password);
        userRepository.save(user);
        return user;
    }

    private Product createProduct(String brand, String model, String category, String description, double price, int rate, String imageUrl, User user) {
        Product product = new Product();
        product.setBrand(brand);
        product.setModel(model);
        product.setCategory(category);
        product.setDescription(description);
        product.setPrice(price);
        product.setRate(rate);
        product.setImageUrl(imageUrl);
        product.setUser(user);
        return product;
    }}