package me.best.main.services;

import me.best.main.models.User;

/**
 * @Author: Sam
 * @Date: 2018/9/12 21:31
 */
public interface UserService {

    /**
     * 新增用户
     * @param user
     * @return
     */
    public String add(User user);
}
