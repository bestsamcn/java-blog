package me.best.main.dao.impl;

import me.best.main.dao.BaseDao;
import me.best.main.dao.UserDao;
import me.best.main.models.User;

import java.util.List;


/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public int add(User user) {
        String sql = "insert into public.user"
                +"(id, account, password, avatar, email, mobile, \"createTime\", \"lastUpdateTime\", \"lastLoginTime\", \"userType\", \"setAdminTime\", \"createIp\")"
                +"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return super.update(sql, user.getId(), user.getAccount(), user.getPassword(), user.getAvatar(), user.getEmail(), user.getMobile(), user.getCreateTime(), user.getLastUpdateTime(), user.getLastLoginTime(), 1, user.getSetAdminTime(), user.getCreateIp());
    }

    @Override
    public int delete(String id) {
        String sql = "delete from public.user where id=?";
        return super.update(sql, id);
    }

    @Override
    public User getById(String id) {
        String sql = "select * from public.user where id=?";
        return super.get(sql, id);
    }

    @Override
    public Object getList(String account) {
        String sql = "select * from public.user where account=?";
        return super.get(sql, account);
    }

    @Override
    public Object getCountByName(String account) {
        String sql = "select count(*) from public.user where account=?";
        return super.getValue(sql, account);
    }

    @Override
    public int edit(User user) {
        String sql = "update public.user"
                +" set password=?, avatar=?, email=?, mobile=?, \"lastUpdateTime\"=now(), \"lastLoginTime\"=?, \"userType\"=?, \"setAdminTime\"=?, \"createIp\"=? where id=?";
        return super.update(sql, user.getPassword(), user.getAvatar(), user.getEmail(), user.getMobile(), user.getLastLoginTime(), user.getUserType(), user.getSetAdminTime(), user.getCreateIp(), user.getId());
    }

    @Override
    public Object getByName(String account) {
        String sql = "select * from public.user where account=?";
        return super.getList(sql, account);
    }
}
