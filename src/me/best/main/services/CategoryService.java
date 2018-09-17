package me.best.main.services;

import net.sf.json.JSONObject;

/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public interface CategoryService {

    /**
     * 新增
     * @param name
     * @return
     */
    public JSONObject add(String name);

    /**
     * 获取单个标签
     * @param id
     * @return
     */
    public JSONObject getById(String id);

    /**
     * 获取列表
     * @return
     */
    public JSONObject getList(String pageIndex, String pageSize);

    /**
     * 删除
     * @param id
     */
    public JSONObject delete(String id);
    /**
     * 编辑
      * @param id
     * @param name
     * @param clickNum
     * @return
     */
    public JSONObject edit(String id, String name, String clickNum);

    /**
     * 获取全部
     * @return
     */
    public JSONObject getAll();
}
