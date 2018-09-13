package me.best.main.services;

import me.best.main.models.Tag;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public interface TagService {

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
    public Tag getById(String id);

    /**
     * 获取列表
     * @return
     */
    public List<Tag> getList();

    /**
     * 删除
     * @param id
     */
    public int delete(String id);

    /**
     * 编辑
     * @param tag
     * @return
     */
    public int edit(Tag tag);
}
