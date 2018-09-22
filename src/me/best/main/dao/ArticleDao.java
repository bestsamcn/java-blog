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
    public int add(Article article);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(String id);

    /**
     * 编辑
     * @param article
     * @return
     */
    public int edit(Article article);

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
    public Object getDetail(String id);

    /**
     * 获取记录总数
     * @return
     */
    public long getTotal();
}


