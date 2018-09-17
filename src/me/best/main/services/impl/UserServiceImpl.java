package me.best.main.services.impl;

import me.best.main.dao.FactoryDao;
import me.best.main.models.User;
import me.best.main.services.FactoryService;
import me.best.main.services.UserService;
import me.best.main.utils.Utils;
import net.sf.json.JSONObject;

import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Pattern;

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
        JSONObject ret = Utils.setResponse(-1, "删除失败", "null");
        if(id == null || id.trim().isEmpty() || id.trim().length() != 32){
            ret.replace("msg", "无此数据");
            return ret;
        }
        try{
            int count = FactoryDao.getUserDao().delete(id);
            if(count == 1){
                ret = Utils.setResponse(0, "删除成功", "null");
            }
        }catch(Exception e){
            ret.replace("msg", "异常");
        }
        return ret;
    }

    @Override
    public JSONObject edit(String id, String email, String mobile) {
        JSONObject ret = Utils.setResponse(-1, "编辑失败", "null");
        User user = (User) FactoryService.getUserService().getById(id, true);
        Pattern emailPattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        Pattern mobilePattern = Pattern.compile("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$");
        if(email != null && !emailPattern.matcher(email).matches()){
            ret.replace("msg", "邮箱格式错误");
            return ret;
        }
        user.setEmail(email);
        if(mobile != null && !mobilePattern.matcher(mobile).matches()){
            ret.replace("msg", "手机格式错误");
            return ret;
        }
        user.setMobile(mobile);
        try{
            int count = FactoryDao.getUserDao().edit(user);
            if(count == 1){
                ret = Utils.setResponse(0, "编辑成功", "null");
            }
        }catch(Exception e){
            ret.replace("msg", "异常");
        }
        return ret;
    }

    @Override
    public Object getById(String id, boolean isServer){
        JSONObject ret = Utils.setResponse(-1, "查询失败", "null");
        if(id == null || id.trim().isEmpty() || id.trim().length() != 32){
            ret.replace("msg", "无此数据");
        }
        try{
            User user = FactoryDao.getUserDao().getById(id);
            if(!!isServer){
                return user;
            }
            if(user != null){
                JSONObject _user = JSONObject.fromObject(user);
                _user.replace("createTime", user.getCreateTime().getTime());
                _user.replace("password", null);
                _user.replace("lastUpdateTime", user.getLastUpdateTime() != null ? user.getLastUpdateTime().getTime() : "null");
                _user.replace("lastLoginTime", user.getLastLoginTime() != null ? user.getLastLoginTime().getTime() : "null");
                _user.replace("setAdminTime", user.getSetAdminTime() != null ? user.getSetAdminTime().getTime() : "null");
                ret = Utils.setResponse(0, "查询成功", _user);
            }
        }catch(Exception e){
            ret.replace("msg","异常");
        }
        return ret;
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
