package com.flamexander.hibernate.first;

import java.util.List;

public interface UserDAO {
    User findById(Long id);
    User findByName(String name);
    List<User> findAll();
    void save(User user);
    void updateNameById(Long id, String newName);
    void testCaching();
}
