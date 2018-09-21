package me.best.main.dao;

import me.best.main.models.Category;
import me.best.main.models.Tag;

import java.util.List;


/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public interface CategoryDao {

    /**
     * 通过id获取标签
     * @param id
     * @return
     */
    public Category getById(String id);

    /**
     * 获取标签列表
     * @return
     */
    public List<Category> getList(int pageIndex, int pageSize);

    /**
     * 获取全部
     * @return
     */
    public List<Category> getAll();

    /**
     * 添加标签
     * @param category
     * @return
     */
    public int add(Category category);


    /**
     * 编辑
      * @param id
     * @param name
     * @param clickNum
     * @return
     */
    public int edit(String id, String name, Object clickNum);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(String id);

    /**
     * 唯一性约束
     * @param name
     * @return
     */
    public long getCountByName(String name);

    /**
     * 获取记录总数
     * @return
     */
    public long getTotal();
}
