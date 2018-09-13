package me.best.main.dao;

import me.best.main.models.Tag;

import java.util.List;


/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public interface TagDao {

    /**
     * 通过id获取标签
     * @param id
     * @return
     */
    public Tag getById(String id);

    /**
     * 获取标签列表
     * @return
     */
    public List<Tag> getAll();

    /**
     * 添加标签
     * @param tag
     * @return
     */
    public int add(Tag tag);


    /**
     * 修改
     * @param tag
     * @return
     */
    public int edit(Tag tag);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(String id);

    public long getCountByName(String name);
}
