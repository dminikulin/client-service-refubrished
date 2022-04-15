package com.example.clientsservice.services.data;

import com.example.clientsservice.models.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void save(){
        User user = new User(0L, "a", "p", "e@e.com",
                User.Status.ACTIVE, Collections.singleton(User.Role.USER));
        user = userService.save(user);
    }

}
