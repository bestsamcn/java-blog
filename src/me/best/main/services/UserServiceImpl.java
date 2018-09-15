package me.best.main.services;

import me.best.main.dao.FactoryDao;
import me.best.main.models.User;
import me.best.main.utils.Utils;
import net.sf.json.JSONObject;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public class UserServiceImpl implements UserService {

    @Override
    public JSONObject add(String account, String password) {

        JSONObject ret = Utils.setResponse(-1, "新增失败", "null");
        if(account == null || account.trim().isEmpty() || account.length() < 3  || account.length() > 24){
            ret.replace("msg", "用户名长度必须大于3小于24");
            return ret;
        }

        if(password == null || password.trim().isEmpty() || password.length() < 6 || password.length() > 24){
            ret.replace("msg", "密码长度必须大于6小于24");
            return ret;
        }

        long row = FactoryDao.getUserDao().getCountByName(account);
        if(row >0){
            ret.replace("msg", "用户重复");
            return ret;
        }

        String id = Utils.getUUID();
        Timestamp createTime = new Timestamp(new Date().getTime());
        Timestamp lastUpdateTime = new Timestamp(new Date().getTime());
        password = Utils.generatePassword(password, "SHA1");
        User user = new User();
        user.setId(id);
        user.setAccount(account);
        user.setPassword(password);
        user.setCreateTime(createTime);
        user.setLastUpateTime(lastUpdateTime);

        try{
            int count = FactoryDao.getUserDao().add(user);
            if(count == 1){
                ret = Utils.setResponse(-1, "新增成功", "null");
            }
        }catch(Exception e){
            ret = Utils.setResponse(-1, "异常", "null");
        }
        return ret;
    }

    @Override
    public JSONObject delete(String id) {
        return null;
    }

    @Override
    public JSONObject edit(User user) {
        return null;
    }

    @Override
    public JSONObject getList(String pageIndex, String pageSize) {
        return null;
    }

    @Override
    public JSONObject getUserByAccount(String account) {
        return null;
    }
}
