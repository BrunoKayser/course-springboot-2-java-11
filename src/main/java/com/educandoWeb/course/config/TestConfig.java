package com.educandoWeb.course.config;


import com.educandoWeb.course.entities.Order;
import com.educandoWeb.course.entities.User;
import com.educandoWeb.course.entities.enums.OrderStatus;
import com.educandoWeb.course.repositories.OrderRepository;
import com.educandoWeb.course.repositories.UserRepository;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

/*
Essa classe é criada para popular o nosso banco de dados
 */

@Configuration// Anotação que precisa colocar a para o Spring entender que é uma classe de configuração
@Profile("test") //Precisa ser igualzinha o profile que esta no yml
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

    }
}
