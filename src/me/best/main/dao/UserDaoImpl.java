package me.best.main.dao;

import me.best.main.models.User;

import java.util.List;


/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao{
    @Override
    public int add(User user) {
        String sql = "insert into public.user"
                +"(id, account, password, avatar, email, mobile, \"createTime\", \"lastUpdateTime\", \"lastLoginTime\", \"userType\", \"setAdminTime\", \"createIp\")"
                +"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return super.update(sql, user.getId(), user.getAccount(), user.getPassword(), user.getAvatar(), user.getEmail(), user.getMobile(), user.getCreateTime(), user.getLastUpdateTime(), user.getLastLoginTime(), 1, user.getSetAdminTime(), user.getCreateIp());
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public List<User> getList(int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public long getCountByName(String account) {
        String sql = "select count(*) from public.user where account=?";
        return (long) super.getValue(sql, account);
    }

    @Override
    public int edit(User user) {
        return 0;
    }
}
