package ua.vld.votingsystem;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.vld.votingsystem.model.*;
import ua.vld.votingsystem.repository.DishRepository;
import ua.vld.votingsystem.repository.RestaurantRepository;
import ua.vld.votingsystem.repository.UserRepository;
import ua.vld.votingsystem.repository.VoteRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static ua.vld.votingsystem.util.PasswordUtil.encode;

public class Main {
    public static void main(String[] args) {
        /*ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml","spring/spring-db.xml");
        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

        *//*UserRepository userRepository = appCtx.getBean(UserRepository.class);
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_USER);
        roles.add(Role.ROLE_ADMIN);
        User user = new User(null,"vlad","sdfa@mail.com","password",roles);
        userRepository.save(user);
        System.out.println(userRepository.getAll());*//*


        VoteRepository voteRepository = appCtx.getBean(VoteRepository.class);


        RestaurantRepository  restaurantRepository = appCtx.getBean(RestaurantRepository.class);
        *//*Restaurant restaurant =restaurantRepository.getWithMaxVotesToday();

        System.out.println(restaurant);*//*
       // Restaurant restaurant = restaurantRepository.get(0);

        List<Restaurant> restaurants = restaurantRepository.getAllToday();
        //Vote vote = voteRepository.save(new Vote(LocalDate.now()),1,0);

        System.out.println(restaurants);
        appCtx.close();*/

        //System.out.println(encode("password"));
    }
}
