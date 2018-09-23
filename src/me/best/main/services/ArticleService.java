package me.best.main.services;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;

public interface ArticleService {

    /**
     * 新增
     * @param creator
     * @param tag
     * @param tagName
     * @param category
     * @param categoryName
     * @param title
     * @param previewText
     * @param content
     * @param codeContent
     * @param poster
     * @return
     */
    public JSONObject add(String creator, String tag, String tagName, String category, String categoryName, String title, String previewText, String content,
                          String codeContent, String poster);

    /**
     * 编辑
     * @param id
     * @param creator
     * @param tag
     * @param tagName
     * @param category
     * @param categoryName
     * @param title
     * @param previewText
     * @param content
     * @param codeContent
     * @param poster
     * @return
     */
    public JSONObject edit(String id, String creator, String tag, String tagName, String category, String categoryName, String title, String previewText,
                           String content,
                          String codeContent, String poster);

    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public JSONObject getDetail(String id);

    /**
     * 获取分页
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public JSONObject getList(String pageIndex, String pageSize);

    /**
     * 删除
     * @param id
     * @return
     */
    public JSONObject delete(String id);
}
