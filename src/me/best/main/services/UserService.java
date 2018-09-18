package me.best.main.services;

import me.best.main.models.User;
import net.sf.json.JSONObject;

/**
 * @Author: Sam
 * @Date: 2018/9/12 21:31
 */
public interface UserService {

    /**
     * 新增用户
     * @param account
     * @param password
     * @return
     */
    public JSONObject add(String account, String password);

    /**
     * 删除用户
     * @param id
     * @return
     */
    public JSONObject delete(String id);

    /**
     * 编辑用户
     * @param email
     * @param mobile
     * @return
     */
    public JSONObject edit(String id, String email, String mobile);

    /**
     * 获取用户分页
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public JSONObject getList(String pageIndex, String pageSize);

    /**
     * 通过用户名获取用户，登陆使用
     * @param account
     * @return
     */
    public JSONObject getUserByAccount(String account);

    /**
     * 通过id获取用户
     * @param id
     * @return
     */
    public Object getById(String id, boolean isServer);

    /**
     * 登陆
     * @param account
     * @param password
     * @return
     */
    public JSONObject login(String account, String password);
}
