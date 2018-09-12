package me.best.main.dao;

import me.best.main.models.User;

import java.util.List;


/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public interface UserDao {
    /**
     *
     * @param id
     * @return User
     */
    public User getById(String id);

    public List<User> getAll();
}
