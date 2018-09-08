package me.best.main.dao;

import me.best.main.models.User;

import java.util.List;

public interface UserDao {
    /**
     *
     * @param id
     * @return User
     */
    public User getById(String id);

    public List<User> getAll();
}
