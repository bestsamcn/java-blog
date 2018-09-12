package me.best.main.dao;

import me.best.main.models.User;

import java.util.List;


/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao{
    @Override
    public User getById(String id) {
        System.out.println(id=" : sdfasdfasdf");
        String sql = "select * from user where id=?";
        return super.get(sql, id);
    }
    @Override
    public List<User> getAll(){
        String sql = "select * from user";
        return super.getAll(sql);
    }
}
