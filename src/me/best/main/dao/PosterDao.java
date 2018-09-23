package me.best.main.dao;

import me.best.main.models.Poster;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/9/23 18:18
 */
public interface PosterDao {

    /**
     * 新增
     * @param poster
     * @return
     */
    public int add(Poster poster);

    /**
     * 通过id获取
     * @param id
     * @return
     */
    public Poster getById(String id);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(String id);

    /**
     * 分页
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<Poster> getList(int pageIndex, int pageSize);

    /**
     * 总数
     * @return
     */
    public int getTotal();
}
