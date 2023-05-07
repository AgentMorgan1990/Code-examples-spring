//package com.example.springsecurityjwt.repository;
//
//
//import com.example.springsecurityjwt.entity.Role;
//import com.example.springsecurityjwt.entity.User;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//@Component
//public class UserRepositoryImpl implements UserRepository {
//
//
//    Role userRole = new Role(
//            1L,
//            "USER",
//            LocalDateTime.now(),
//            LocalDateTime.now()
//    );
//
//    Role superadminRole = new Role(
//            2L,
//            "SUPERADMIN",
//            LocalDateTime.now(),
//            LocalDateTime.now()
//    );
//
//    private Map<String, User> users = Map.of(
//            "Bob",
//            new User(1L, "Bob", "$2y$10$Cx/pNQshY1CQZvPmBZqmDejkUv06KV1Iq0n8MLnQsrKGPhiOsyqBO", List.of(superadminRole)),
//            "Jack",
//            new User(2L, "Jack", "$2y$10$Cx/pNQshY1CQZvPmBZqmDejkUv06KV1Iq0n8MLnQsrKGPhiOsyqBO", List.of(userRole,superadminRole))
//    );
//
//    @Override
//    public Optional<User> findByUserName(String username) {
//        return Optional.of(users.get(username));
//    }
//}
