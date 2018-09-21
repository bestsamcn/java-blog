package me.best.main.dao;


/**
 * @Author: Sam
 * @Date: 2018/9/21 18:33
 */

import me.best.main.models.Article;

import java.util.List;

public interface ArticleDao {

    /**
     * 新增
     * @param article
     * @return
     */
    public String add(Article article);

    /**
     * 删除
     * @param id
     * @return
     */
    public String delete(String id);

    /**
     * 编辑
     * @param article
     * @return
     */
    public String edit(Article article);

    /**
     * 分页
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<Article> getList(int pageIndex, int pageSize);

    /**
     * 获取文章
     * @param id
     * @return
     */
    public Article getById(String id);
}


