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

    /**
     * 获取用户列表
     * @return
     */
    public List<User> getList(int pageIndex, int pageSize);

    /**
     * 验证唯一用户名
     * @param account
     * @return
     */
    public long getCountByName(String account);

    /**
     * 新增用户
     * @param user
     * @return
     */
    public int add(User user);

    /**
     * 编辑用户
     * @param user
     * @return
     */
    public int edit(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(String id);
}
