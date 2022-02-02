package com.example.spring_boot.dao;
import com.example.spring_boot.model.User;
import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUser(int id);

    void save(User user);

    void update(int id, User updatedUser);

    void delete(int id);

    User getUserByName(String s);
}
